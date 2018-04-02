package com.example.liuhong.weatherkotlintest

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.liuhong.weatherkotlintest.net.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecastList.layoutManager = LinearLayoutManager(this)
        doAsync {
            val result = RequestForecastCommand("1022").execute()
//            val result = ForecastProvider().requestByZipCode("1022",7 )
            uiThread {
                forecastList.adapter = ForecastListAdapter(result) { list ->
                    startActivity<DetailActivity>(DetailActivity.ID to list.id,
                            DetailActivity.CITY_NAME to list.city)
                }
            }
        }

        val container: ViewGroup = find(R.id.container)
        val view = container[0]

        supportsLollipop {
            window.statusBarColor = Color.BLACK
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

    operator fun ViewGroup.get(position: Int): View = getChildAt(position)

    inline fun supportsLollipop(code: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            code()
        }
    }
}
