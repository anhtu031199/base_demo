package com.tuna.ctech.data.repository

import com.tuna.ctech.data.remote.response.BaseResponse
import com.tuna.ctech.data.remote.response.EmployeeResponse
import com.tuna.nothingapp.data.remote.request.EmployeeRequestBody

interface EmployeeRepository {
    suspend fun getListEmployee(employeeRequestBody: EmployeeRequestBody): BaseResponse
}
