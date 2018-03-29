package com.example.liuhong.weatherkotlintest.db

import android.database.sqlite.SQLiteDatabase
import com.example.liuhong.weatherkotlintest.db.datamapper.DataMapper
import com.example.liuhong.weatherkotlintest.db.helper.ForecastDbHelper
import com.example.liuhong.weatherkotlintest.db.model.CityForecast
import com.example.liuhong.weatherkotlintest.db.model.CityForecastTable
import com.example.liuhong.weatherkotlintest.db.model.DayForecast
import com.example.liuhong.weatherkotlintest.db.model.DayForecastTable
import com.example.liuhong.weatherkotlintest.domain.model.ForecastList
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/***
 * Created by du on 2018/3/29.
 * Description: ForecastDb数据库操作，比如查询、插入
 */
class ForecastDb {

    private val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance
    private val dataMapper: DataMapper = DataMapper()

    /**
     * 查询操作.
     */
    private fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {
        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME)
                .whereArgs(dailyRequest, "id" to zipCode, "date" to date)
                .parseList {
                    DayForecast(HashMap(it))
                }
        /*.parseList(object : MapRowParser<DayForecast> {
            //RowParser和MapRowParser会把cursor转换成一个对象的集合
            //RowParser是依赖列的顺序的；MapRowParser是从map中拿到Key值作为column的key名的
            override fun parseRow(columns: Map<String, Any?>): DayForecast {
                return DayForecast(HashMap(columns))
            }
        })*/
        val city = select(CityForecastTable.NAME)
                .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt {
                    CityForecast(HashMap(it), dailyForecast)
                }
        if (city != null) {
            dataMapper.convertToDomain(city)
        } else {
            null
        }
    }

    private fun <T : Any> SelectQueryBuilder.parseList(parser: (Map<String, Any?>) -> T): List<T> =
            parseList(object : MapRowParser<T> {
                override fun parseRow(columns: Map<String, Any?>): T {
                    return parser.invoke(columns)
                }
            })

    private fun <T : Any> SelectQueryBuilder.parseOpt(parser: (Map<String, Any?>) -> T): T? {
        return parseOpt(object : MapRowParser<T> {
            override fun parseRow(columns: Map<String, Any?>): T {
                return parser(columns)
            }
        })
    }

    /**
     * 先清除两张表，然后分别插入数据.
     */
    private fun saveForcast(forecast: ForecastList) = forecastDbHelper.use {
        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)
        with(dataMapper.convertFromDomain(forecast)) {
            //使用*，表示这个array会被分解成为一个verarg参数【在Java中是自动处理的，在Kotlin中需要明确指出】
            insert(CityForecastTable.NAME, *map.toVarargArray())
            dailyForcast.forEach {
                insert(DayForecastTable.NAME, *it.map.toVarargArray())
            }
        }
    }

    private fun SQLiteDatabase.clear(tableName: String) {
        execSQL("delete from ${tableName}")
    }

    private fun <K, V : Any> MutableMap<K, V?>.toVarargArray(): Array<Pair<K, V?>> =
            map({
                Pair(it.key, it.value)
            }).toTypedArray()

}