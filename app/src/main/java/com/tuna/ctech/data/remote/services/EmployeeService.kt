package com.tuna.ctech.data.remote.services

import com.tuna.ctech.data.remote.response.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EmployeeService {
    @GET("api/cms/Employee/GetList")
    suspend fun getListEmployee(
        @Query("pageIndex") pageIndex: Int,
        @Query("pageSize") pageSize: Int,
        @Query("sort") sort: String,
        @Query("fullName") fullName: String,
    ): BaseResponse
//
//    @GET("/api/cms/Employee/Create")
//    suspend fun getListEmployee(
//        @Query("pageIndex") pageIndex: Int,
//        @Query("pageSize") pageSize: Int,
//        @Query("sort") sort: String,
//        @Query("fullName") fullName: String,
//    ): BaseResponse
}
