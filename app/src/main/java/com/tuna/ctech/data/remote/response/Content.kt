package com.tuna.ctech.data.remote.response

data class Content(
    val cgisId: Any,
    val hasNextPage: Boolean,
    val hasPreviousPage: Boolean,
    val items: List<EmployeeResponse>,
    val pageCount: Int,
    val pageIndex: Int,
    val pageSize: Int,
    val totalItemCount: Int
)