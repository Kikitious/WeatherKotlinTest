package com.example.liuhong.weatherkotlintest.dataprovider

import com.example.liuhong.weatherkotlintest.domain.model.Forecast
import com.example.liuhong.weatherkotlintest.domain.model.ForecastList

/***
 * Created by du on 2018/3/30.
 * Description:
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: String, date: Long): ForecastList?
    fun requestDayForecast(id: Long): Forecast?
}