package com.example.liuhong.weatherkotlintest.net

/***
 * Created by du on 2018/3/20.
 * Description:
 */
interface Command<T> {
    fun execute(): T
}