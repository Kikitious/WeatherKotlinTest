package com.example.liuhong.weatherkotlintest

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.liuhong.weatherkotlintest.net.RequestForecastCommand
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList = find<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        async {
            val result = RequestForecastCommand("").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result)
            }
        }
    }

    private fun ankoToast() {
        toast("Hello")
        longToast(R.string.app_name)
    }

    fun niceToast(message: String,
                  tag: String = MainActivity::class.java.simpleName,
                  length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "[$localClassName] $message", length).show()
    }

    fun Context.toast(message: String,
                      length: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, length).show()
    }
}
