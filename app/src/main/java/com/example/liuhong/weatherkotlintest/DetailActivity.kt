package com.example.liuhong.weatherkotlintest

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.liuhong.weatherkotlintest.domain.model.Forecast
import com.example.liuhong.weatherkotlintest.net.RequestDayForecastCommand
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/***
 * Created by du on 2018/4/2.
 * Description:
 */
class DetailActivity : AppCompatActivity() {

    companion object {
        const val ID = "DetailActivity:id"
        const val CITY_NAME = "DetailActivity:cityName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        title = intent.getStringExtra(CITY_NAME)

        doAsync {
            val result = RequestDayForecastCommand(intent.getLongExtra(ID, -1)).execute()
            uiThread {
                bindForecast(result)
            }
        }
    }

    private fun bindForecast(result: Forecast) {
        with(result) {
            Picasso.with(ctx).load(iconUrl).into(icon)
            supportActionBar?.subtitle = date.toString()
            weatherDescription.text = description
            bindWeather(low to minTemperature, high to maxTemperature)
        }
    }

    private fun bindWeather(vararg views: Pair<Int, TextView>) = views.forEach {
        val color = when (it.first) {
            in -50..0 ->
                Color.RED
            in 0..15 ->
                Color.YELLOW
            else ->
                Color.GREEN
        }
        it.second.setTextColor(color)
        it.second.text = it.first.toString()
    }
}