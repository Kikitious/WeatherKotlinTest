package com.example.liuhong.weatherkotlintest.base

import android.app.Application
import com.example.liuhong.weatherkotlintest.delegates.DelegatesExt

/***
 * Created by du on 2018/3/21.
 * Description:
 */
class App : Application() {

    companion object {
        //Delegates.notNull 如果在instance未赋值之前使用的话，会抛出异常
        //var instance: App by Delegates.notNull<App>()

        //自定义的委托，
        //如果在instance未赋值之前使用的话，会抛出异常
        //如果在已经有值得情况下，还去set的话，也会抛出异常，即只能赋一次值
        var instance: App by DelegatesExt.notNullSingleValue<App>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}