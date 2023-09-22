package com.tuna.nothingapp.data.remote.request

data class EmployeeRequestBody(
    var fullname: String,
    var pageIndex: Int = 0,
    var pageSize: Int = 0,
    var sort: String,
)
