package com.tuna.ctech.base.adapter

import androidx.recyclerview.widget.DiffUtil
import com.tuna.ctech.base.adapter.BaseItemModel

class DiffCallback(
    private val oldList: List<BaseItemModel>,
    private val newList: List<BaseItemModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].primaryField == newList[newItemPosition].primaryField
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
