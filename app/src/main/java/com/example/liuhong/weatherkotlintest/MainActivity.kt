package com.example.liuhong.weatherkotlintest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = getString(R.string.weather_welcome_string)

        add(3, 5)
        addDirectly(3, 5)
    }

    fun log(name: String): Unit {
        //如果不指定返回值，默认返回Unit，类似于Java中的void
        //但是Unit是一个真正的对象
    }

    fun add(x: Int, y: Int): Int {
        return x + y
    }

    fun addDirectly(x: Int, y: Int): Int = x + y
    //返回的结果可以使用一个表达式计算出来的，可以不使用括号直接使用等号
}
