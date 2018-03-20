package com.example.liuhong.weatherkotlintest.domain.model

/***
 * Created by du on 2018/3/20.
 * Description:
 */
data class ForecastList(
        val city: String,
        val country: String,
        val dailyForecast: List<Forecast>
)

data class Forecast(
        val date: String,
        val description: String,
        val high: Int,
        val low: Int
)