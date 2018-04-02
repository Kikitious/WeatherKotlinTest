package com.example.liuhong.weatherkotlintest.dataprovider

import com.example.liuhong.weatherkotlintest.db.ForecastDb
import com.example.liuhong.weatherkotlintest.domain.model.Forecast
import com.example.liuhong.weatherkotlintest.domain.model.ForecastList
import com.example.liuhong.weatherkotlintest.net.ForecastServer

/***
 * Created by du on 2018/3/30.
 * Description:
 */
class ForecastProvider(private val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    companion object {
        const val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

    /*fun requestByZipCode(zipCode: String, days: Int): ForecastList {
        val result = sources.firstResult {
            requestSource(it, days, zipCode)
        }
        return result
    }*/

    fun requestByZipCode(zipCode: String, days: Int): ForecastList = requestToSources {
        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size() >= days) res else null
    }

    fun requestSource(source: ForecastDataSource, days: Int, zipCode: String): ForecastList? {
        val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size() >= days)
            return res
        else
            return null
    }

    private fun <T : Any> requestToSources(f: (ForecastDataSource) -> T?): T = sources.firstResult {
        f(it)
    }

    fun requestForecast(id: Long): Forecast {
        return requestToSources {
            it.requestDayForecast(id)
        }
    }


    private inline fun <T, R : Any?> Iterable<T>.firstResult(predicate: (T) -> R?): R {
        for (element in this) {
            val result = predicate(element)
            if (result != null)
                return result
        }
        throw NoSuchElementException("No element matching predicate was found")
    }


}