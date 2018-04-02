package com.example.liuhong.weatherkotlintest.net

import com.example.liuhong.weatherkotlintest.dataprovider.ForecastProvider
import com.example.liuhong.weatherkotlintest.domain.model.Forecast

/***
 * Created by du on 2018/4/2.
 * Description:
 */
class RequestDayForecastCommand(val id: Long,
                                val forecastProvider: ForecastProvider = ForecastProvider())
    : Command<Forecast> {

    override fun execute(): Forecast {
        return forecastProvider.requestForecast(id)
    }

}