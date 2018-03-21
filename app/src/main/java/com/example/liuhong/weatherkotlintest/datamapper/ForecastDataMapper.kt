package com.example.liuhong.weatherkotlintest.datamapper

import com.example.liuhong.weatherkotlintest.domain.model.ForecastList
import com.example.liuhong.weatherkotlintest.model.Forecast
import com.example.liuhong.weatherkotlintest.model.ForecastResult
import java.text.DateFormat
import java.util.*
import com.example.liuhong.weatherkotlintest.domain.model.Forecast as ModelForecast

/***
 * Created by du on 2018/3/20.
 * Description:
 */
class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        /*return list.map {
            ModelForecast(convertDate(it.dt), it.weather[0].description,
                    it.temp.max.toInt(), it.temp.min.toInt())
        }*/
        return list.map {
            convertForecastItemToDomain(it)
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(
                convertDate(forecast.dt),
                forecast.weather[0].description,
                forecast.temp.max.toInt(),
                forecast.temp.min.toInt(),
                generateIconUrl(iconCode = forecast.weather[0].icon)
        )
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/$iconCode.png"
}