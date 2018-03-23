package com.example.liuhong.weatherkotlintest.db.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.liuhong.weatherkotlintest.base.App
import com.example.liuhong.weatherkotlintest.db.model.CityForecastTable
import com.example.liuhong.weatherkotlintest.db.model.DayForecastTable
import org.jetbrains.anko.db.*

/***
 * Created by du on 2018/3/23.
 * Description:
 */
class ForecastDbHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(
        ctx, ForecastDbHelper.DB_NAME,
        null, ForecastDbHelper.DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        /*db?.createTable(CityForecastTable.NAME, true,
                Pair(CityForecastTable.ID, INTEGER + PRIMARY_KEY),
                Pair(CityForecastTable.CITY, TEXT),
                Pair(CityForecastTable.COUNTRY, TEXT))*/
        db?.createTable(CityForecastTable.NAME, true,
                CityForecastTable.ID to INTEGER + PRIMARY_KEY,
                CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to TEXT)
        db?.createTable(DayForecastTable.NAME, true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(CityForecastTable.NAME, true)
        db?.dropTable(DayForecastTable.NAME, true)
        onCreate(db)
    }


    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        //使用lazy，直到真的被调用才会创建
        val instance: ForecastDbHelper by lazy {
            ForecastDbHelper()
        }
    }
}