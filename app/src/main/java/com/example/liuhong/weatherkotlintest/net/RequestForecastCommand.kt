package com.example.liuhong.weatherkotlintest.net

import com.example.liuhong.weatherkotlintest.datamapper.ForecastDataMapper
import com.example.liuhong.weatherkotlintest.domain.Command
import com.example.liuhong.weatherkotlintest.domain.model.ForecastList

/***
 * Created by du on 2018/3/20.
 * Description:
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}