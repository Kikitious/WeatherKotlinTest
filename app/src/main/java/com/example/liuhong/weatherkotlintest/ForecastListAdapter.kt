package com.example.liuhong.weatherkotlintest

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.liuhong.weatherkotlintest.domain.model.ForecastList

/***
 * Created by liuhong on 2018/3/5.
 * Description: 天气预报ListAdapter
 */
class ForecastListAdapter(private val weekForecast: ForecastList) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(textView = TextView(parent?.context))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(weekForecast[position]) {
            holder!!.textView.text = "${this.date} - ${this.description} - ${this.high}/${this.low}"
        }
    }

    override fun getItemCount(): Int = weekForecast.size()


    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}