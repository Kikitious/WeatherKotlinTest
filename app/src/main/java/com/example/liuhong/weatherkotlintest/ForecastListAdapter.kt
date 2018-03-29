package com.example.liuhong.weatherkotlintest

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.liuhong.weatherkotlintest.domain.model.Forecast
import com.example.liuhong.weatherkotlintest.domain.model.ForecastList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*

/***
 * Created by liuhong on 2018/3/5.
 * Description: 天气预报ListAdapter
 */
class ForecastListAdapter(private val weekForecast: ForecastList,
                          private val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size()

    class ViewHolder(view: View, private val listener: (Forecast) -> Unit) :
            RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(itemView.icon)
                itemView.date.text = date.toString()
                itemView.description.text = description
                itemView.maxTemperature.text = "${high.toString()}"
                itemView.minTemperature.text = "${low.toString()}"
                itemView.setOnClickListener {
                    listener(forecast)
                    //listener.invoke(forecast)
                }
            }
        }
    }

}