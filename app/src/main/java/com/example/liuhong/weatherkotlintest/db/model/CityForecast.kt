package com.example.liuhong.weatherkotlintest.db.model

/***
 * Created by du on 2018/3/28.
 * Description: 跟ForecastList差不多，比ForecastList多了map委托
 */
class CityForecast(val map: MutableMap<String, Any?>,
                   val dailyForcast: List<DayForecast>) {

    var _id: Long by map
    var city: String by map
    var country: String by map

    constructor(id: Long, city: String, country: String, dailyForcast: List<DayForecast>)
            : this(HashMap(), dailyForcast) {
        this._id = id
        this.city = city
        this.country = country
    }

}