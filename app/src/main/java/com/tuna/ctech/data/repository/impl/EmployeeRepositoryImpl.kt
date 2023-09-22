package com.tuna.ctech.data.repository.impl

import com.tuna.ctech.data.remote.response.BaseResponse
import com.tuna.ctech.data.remote.services.EmployeeService
import com.tuna.nothingapp.data.remote.request.EmployeeRequestBody
import com.tuna.ctech.data.repository.EmployeeRepository
import javax.inject.Inject

class EmployeeRepositoryImpl @Inject constructor(
    private val employeeService: EmployeeService,
) : EmployeeRepository {

    override suspend fun getListEmployee(employeeRequestBody: EmployeeRequestBody): BaseResponse {
        return employeeService.getListEmployee(
            employeeRequestBody.pageIndex,
            employeeRequestBody.pageSize,
            employeeRequestBody.sort,
            employeeRequestBody.fullname,
        )
    }
}
