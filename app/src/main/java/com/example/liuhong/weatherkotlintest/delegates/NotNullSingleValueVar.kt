package com.example.liuhong.weatherkotlintest.delegates

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/***
 * Created by du on 2018/3/23.
 * Description:自定义委托
 */
class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {

    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value =
                if (this.value == null) value
                else throw IllegalStateException("${property.name} already initialized")
    }

}


object DelegatesExt {

    fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()

}