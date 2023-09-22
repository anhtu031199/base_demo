package com.tuna.nothingapp.data.local.model

import com.tuna.ctech.R
import com.tuna.ctech.base.adapter.BaseItemModel
import com.tuna.ctech.data.remote.response.Daily

data class DailyItemUI(
    val daily: Daily,
    val onClick: (DailyItemUI) -> Unit
) : BaseItemModel {
    val dt: Long = daily.dt
    val temp: Double = daily.temp.day
    val main: String? = daily.weather?.getOrNull(0)?.main
    val icon: String? = daily.weather?.getOrNull(0)?.icon
    val maxTemp: Int = daily.temp.max.toInt()
    val minTemp: Int = daily.temp.min.toInt()

    override val layoutId: Int = R.layout.item_daily

    fun onItemClick() {
        onClick(this)
    }
}