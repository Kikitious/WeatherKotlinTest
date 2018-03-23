package com.example.liuhong.weatherkotlintest.delegates

/***
 * Created by du on 2018/3/23.
 * Description: map委托
 */
class Configuration(map: Map<String, Any?>) {
    val width: Int by map
    val height: Int by map
    val dp: Int by map
    val deviceName: String by map


    fun test() {
        val conf = Configuration(mapOf(
                "width" to 1080,
                "height" to 1920,
                "dp" to 480,
                "deviceName" to "Signal's iPhone"
        ))
    }
}