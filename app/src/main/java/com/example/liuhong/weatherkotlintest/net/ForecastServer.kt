package com.example.liuhong.weatherkotlintest.net

import com.example.liuhong.weatherkotlintest.dataprovider.ForecastDataSource
import com.example.liuhong.weatherkotlintest.db.ForecastDb
import com.example.liuhong.weatherkotlintest.domain.model.Forecast
import com.example.liuhong.weatherkotlintest.domain.model.ForecastList

/***
 * Created by du on 2018/3/30.
 * Description:
 */
class ForecastServer(private val dataMapper: ServerDataMapper = ServerDataMapper(),
                     private val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {

    override fun requestDayForecast(id: Long): Forecast? {
        val result = ForecastRequest("").execute()
        val converted = dataMapper.convertFromDataModel(result)
        return converted[0]
    }

    override fun requestForecastByZipCode(zipCode: String, date: Long): ForecastList? {
        val result = ForecastRequest(zipCode).execute()
        val converted = dataMapper.convertFromDataModel(result)
        /*forecastDb.saveForcast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)*/
        return converted
    }


}