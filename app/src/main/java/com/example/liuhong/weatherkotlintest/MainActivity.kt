package com.example.liuhong.weatherkotlintest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = getString(R.string.weather_welcome_string)

        add(3, 5)
        addDirectly(3, 5)
        toast("")
        toast("", Toast.LENGTH_LONG)
        niceToast(message = "Oh Scard me", length = Toast.LENGTH_LONG)
    }

    fun log(name: String): Unit {
        //如果不指定返回值，默认返回Unit，类似于Java中的void
        //但是Unit是一个真正的对象
    }

    private fun add(x: Int, y: Int): Int {
        return x + y
    }

    private fun addDirectly(x: Int, y: Int): Int = x + y
    //返回的结果可以使用一个表达式计算出来的，可以不使用括号直接使用等号

    //第二个参数length制定了一个默认值，调用的时候可以不传这个值
    //避免重载
    fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }

    fun niceToast(message: String,
                  tag: String = MainActivity::class.java.simpleName,
                  length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "[$localClassName] $message", length).show()
    }
}
