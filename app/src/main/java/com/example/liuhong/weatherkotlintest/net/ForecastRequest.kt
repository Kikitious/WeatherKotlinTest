package com.example.liuhong.weatherkotlintest.net

import com.example.liuhong.weatherkotlintest.model.ForecastResult
import com.google.gson.Gson

/***
 * Created by du on 2018/3/20.
 * Description:
 */
class ForecastRequest(val zipCode: String) {

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPIP=$APP_ID&q="
        private val FAKE_URL = "http://samples.openweathermap.org/data/2.5/forecast/daily?id=524901&appid=b1b15e88fa797225412429c1c50c122a1"
    }

    fun execute(): ForecastResult {
        //val forecastJsonStr = java.net.URL(COMPLETE_URL + zipCode).readText()
        val forecastJsonStr = java.net.URL(FAKE_URL).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }

}