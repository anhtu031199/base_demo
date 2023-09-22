package com.tuna.ctech.data.local.model

import com.tuna.ctech.R
import com.tuna.ctech.base.adapter.BaseItemModel
import com.tuna.ctech.data.remote.response.EmployeeResponse
import java.util.Date

data class EmployeeItemUI(
    val employee: EmployeeResponse,
    val onClick: (EmployeeItemUI) -> Unit,
) : BaseItemModel {
    val fullname: String = employee.fullname
    val gender: Boolean = employee.gender
    val birthday: Date = employee.birthday
    val email: String = employee.email
    val phoneNumber: String? = employee.phoneNumber
    val salary: Long = employee.salary
    val department: Int = employee.department
    val image: String? = employee.image
    val biography: String? = employee.biography
    val createDate: Date = employee.createDate
    val modifiedDate: Date = employee.modifiedDate

    override val layoutId: Int = R.layout.item_employee

    fun onItemClick() {
        onClick(this)
    }
}
