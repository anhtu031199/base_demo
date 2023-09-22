package com.tuna.ctech.data.local.model

import com.tuna.ctech.R
import com.tuna.ctech.base.adapter.BaseItemModel
import com.tuna.ctech.data.remote.response.Hourly

data class HourlyItemUI(
    val hourly: Hourly,
    val timeZone: String,
    val onClick: (HourlyItemUI) -> Unit
) : BaseItemModel {
    val dt: Long = hourly.dt
    val icon: String = hourly.weather[0].icon
    val temp: Double = hourly.temp

    override val layoutId: Int = R.layout.item_hourly

    fun onItemClick() {
        onClick(this)
    }
}