package com.example.liuhong.weatherkotlintest.domain.model

/***
 * Created by du on 2018/3/20.
 * Description: 城市model及城市的每日天气model
 */
data class ForecastList(
        val id: Long,
        val city: String,
        val country: String,
        val dailyForecast: List<Forecast>) {

    operator fun get(position: Int) = dailyForecast[position]
    //自动推断类型，可以省略返回值
    fun size() = dailyForecast.size
}

data class Forecast(
        val date: Long,
        val description: String,
        val high: Int,
        val low: Int,
        val iconUrl: String
)