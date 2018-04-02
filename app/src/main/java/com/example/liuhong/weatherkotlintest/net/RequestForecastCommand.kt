package com.example.liuhong.weatherkotlintest.net

import com.example.liuhong.weatherkotlintest.dataprovider.ForecastProvider
import com.example.liuhong.weatherkotlintest.domain.model.ForecastList

/***
 * Created by du on 2018/3/20.
 * Description:
 */
class RequestForecastCommand(private val zipCode: String,
                             private val forecastProvider: ForecastProvider = ForecastProvider())
    : Command<ForecastList> {

    companion object {
        const val DAYS = 7
    }
    //zipCode只能去得到，不能去修改它
    //如果觉得某些属性因为一些原因不能对别人可见，就把它定义为private
    override fun execute(): ForecastList {
        return forecastProvider.requestByZipCode(zipCode, DAYS)
        //val forecastRequest = ForecastRequest(zipCode)
        //return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}