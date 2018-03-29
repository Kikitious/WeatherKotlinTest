package com.example.liuhong.weatherkotlintest.db.datamapper

import com.example.liuhong.weatherkotlintest.db.model.CityForecast
import com.example.liuhong.weatherkotlintest.db.model.DayForecast
import com.example.liuhong.weatherkotlintest.domain.model.Forecast
import com.example.liuhong.weatherkotlintest.domain.model.ForecastList

/***
 * Created by du on 2018/3/29.
 * Description: ForecastList与CityForecast的互转，借助map委托，能够很简单的创建数据表
 */
class DataMapper {

    /**
     * CityForecast->ForecastList.
     */
    fun convertToDomain(forecast: CityForecast) = with(forecast) {
        val daily = this.dailyForcast.map {
            convertDayToDomain(it)
        }
        ForecastList(_id, this.city, this.country, daily)
    }

    fun convertDayToDomain(dayForecast: DayForecast) = with(dayForecast) {
        Forecast(date, description, high, low, iconUrl)
    }

    /**
     * ForecastList->CityForecast.
     */
    fun convertFromDomain(forecast: ForecastList) = with(forecast) {
        val daily = this.dailyForecast.map {
            converDayFromDomain(id, it)
        }
        CityForecast(id, city, country, daily)
    }

    fun converDayFromDomain(cityId: Long, forecast: Forecast) = with(forecast) {
        DayForecast(date, description, high, low, iconUrl, cityId)
    }
}