package com.example.liuhong.weatherkotlintest

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/***
 * Created by liuhong on 2018/3/5.
 * Description: 天气预报ListAdapter
 */
class ForecastListAdapter(val items: List<String>) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(textView = TextView(parent?.context))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.textView.text = items.get(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}