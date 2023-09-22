package com.tuna.ctech.ui.home

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.tuna.ctech.base.BaseViewModel
import com.tuna.ctech.data.local.model.EmployeeItemUI
import com.tuna.ctech.data.remote.response.BaseResponse
import com.tuna.ctech.data.remote.response.EmployeeResponse
import com.tuna.ctech.data.remote.response.Hourly
import com.tuna.ctech.data.repository.EmployeeRepository
import com.tuna.ctech.navigation.NavigationCommand
import com.tuna.nothingapp.data.remote.request.EmployeeRequestBody
import com.tuna.nothingapp.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    app: Application,
    private val employeeRepository: EmployeeRepository,
) : BaseViewModel(app) {
    val baseResponse by lazy { SingleLiveEvent<BaseResponse>() }
    val listEmployee by lazy { SingleLiveEvent<List<EmployeeItemUI>>() }
    val errorMessage by lazy { SingleLiveEvent<String>() }
    val showErrorDialog by lazy { SingleLiveEvent<Boolean>() }
    val showLoading by lazy { SingleLiveEvent<Boolean>() }
    var hourlyCallback: HourlyCallback? = null
    var itemClickCallback: ItemClickCallback? = null

    fun getData() {
        viewModelScope.launch {
            try {
                val response = employeeRepository.getListEmployee(
                    EmployeeRequestBody(
                        fullname = "",
                        pageIndex = 1,
                        pageSize = 10,
                        sort = "",
                    ),
                )
                Timber.d("---Response: $response")
                baseResponse.postValue(response)
                listEmployee.postValue(
                    response.content.items.map { item ->
                        EmployeeItemUI(
                            employee = item,
                            onClick = {
                                itemClickCallback?.onItemClickCallback(item)
                            },
                        )
                    },
                )
            } catch (e: Exception) {
                Timber.e("--- $e")
                e.printStackTrace()
            }
        }
    }

    fun getDataWithName(name: String) {
        viewModelScope.launch {
            try {
                val response = employeeRepository.getListEmployee(
                    EmployeeRequestBody(
                        fullname = name,
                        pageIndex = 1,
                        pageSize = 10,
                        sort = "",
                    ),
                )
                Timber.d("---Response: $response")
                baseResponse.postValue(response)
                listEmployee.postValue(
                    response.content.items.map { item ->
                        EmployeeItemUI(
                            employee = item,
                            onClick = {
                                itemClickCallback?.onItemClickCallback(item)
                            },
                        )
                    },
                )
            } catch (e: Exception) {
                Timber.e("--- $e")
                e.printStackTrace()
            }
        }
    }

    fun navigateToDetail(hourly: Hourly) {
        navigate(
            NavigationCommand.To(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(hourly),
            ),
        )
    }

    interface HourlyCallback {
        fun onHourlyItemClick(item: Hourly)
    }

    interface ItemClickCallback {
        fun onItemClickCallback(item: EmployeeResponse)
    }
}
