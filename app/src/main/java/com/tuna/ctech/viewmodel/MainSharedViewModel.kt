package com.tuna.ctech.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.tuna.ctech.base.BaseViewModel
import com.tuna.nothingapp.data.local.entity.Location
import com.tuna.nothingapp.data.local.model.DailyItemUI
import com.tuna.ctech.data.local.model.HourlyItemUI
import com.tuna.ctech.data.remote.response.Current
import com.tuna.ctech.data.repository.EmployeeRepository
import com.tuna.nothingapp.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainSharedViewModel @Inject constructor(
    app: Application,
    private val employeeRepository: EmployeeRepository,
) : BaseViewModel(app) {
    private val _currentWeather by lazy { SingleLiveEvent<Current>() }
    private val _locationList by lazy { SingleLiveEvent<List<Location>>() }
    private val _currentLocation by lazy { SingleLiveEvent<String>() }
    private val _currentImg by lazy { SingleLiveEvent<String>() }
    private val _currentTemp by lazy { SingleLiveEvent<Double>() }
    private val _feelsLikeTemp by lazy { SingleLiveEvent<Int>() }
    private val _windSpeed by lazy { SingleLiveEvent<Int>() }
    private val _uvIndex by lazy { SingleLiveEvent<Double>() }
    private val _humidity by lazy { SingleLiveEvent<Int>() }
    private val _pressure by lazy { SingleLiveEvent<Int>() }
    private val _dateTime by lazy { SingleLiveEvent<String>() }
    private val _longitude by lazy { SingleLiveEvent<Double>() }
    private val _latitude by lazy { SingleLiveEvent<Double>() }
    private val _hasLocationPermission by lazy { SingleLiveEvent<Boolean>() }
    private val _errorMessage by lazy { SingleLiveEvent<String>() }
    private val _listHourlyForecast by lazy { SingleLiveEvent<List<HourlyItemUI>>() }
    private val _listDailyForecast by lazy { SingleLiveEvent<List<DailyItemUI>>() }
    var hourlyCallback: HourlyCallback? = null
    var dailyCallback: DailyCallback? = null

    val currentWeather: SingleLiveEvent<Current> = _currentWeather
    val locationList: SingleLiveEvent<List<Location>> = _locationList

    //    val locationListUI: SingleLiveEvent<List<LocationItemUI>> = _locationListUI
    val currentLocation: SingleLiveEvent<String> = _currentLocation
    val currentImg: SingleLiveEvent<String> = _currentImg
    val currentTemp: SingleLiveEvent<Double> = _currentTemp
    val feelsLikeTemp: SingleLiveEvent<Int> = _feelsLikeTemp
    val windSpeed: SingleLiveEvent<Int> = _windSpeed
    val uvIndex: SingleLiveEvent<Double> = _uvIndex
    val humidity: SingleLiveEvent<Int> = _humidity
    val pressure: SingleLiveEvent<Int> = _pressure
    val dateTime: SingleLiveEvent<String> = _dateTime
    val hasLocationPermission: SingleLiveEvent<Boolean> = _hasLocationPermission
    val longitude: SingleLiveEvent<Double> = _longitude
    val latitude: SingleLiveEvent<Double> = _latitude
    val showLoading by lazy { SingleLiveEvent<Boolean>() }
    val showErrorDialog by lazy { SingleLiveEvent<Boolean>() }
    val hasData by lazy { SingleLiveEvent<Boolean>() }
    val showUV by lazy { SingleLiveEvent<Boolean>() }
    val errorMessage: SingleLiveEvent<String> = _errorMessage
    val listHourlyForecast: MutableLiveData<List<HourlyItemUI>> = _listHourlyForecast
    val listDailyForecast: MutableLiveData<List<DailyItemUI>> = _listDailyForecast
//
//    fun initData() {
//        val tomorrow = Calendar.getInstance()
//        tomorrow.add(Calendar.DATE, 1)
//        viewModelScope.launch {
//            showErrorDialog.value = false
//            showLoading.value = true
//            try {
//                val weather = weatherRepository.getCurrentWeather(
//                    WeatherRequestBody(
//                        latitude.value ?: 0.0,
//                        longitude.value ?: 0.0,
//                    ),
//                )
//                weather.current?.let {
//                    _currentWeather.postValue(it)
//                    _currentImg.postValue(it.weather?.getOrNull(0)?.icon)
//                    _currentTemp.postValue(it.temp)
//                    _feelsLikeTemp.postValue(it.feels_like.toInt())
//                    _windSpeed.postValue(it.wind_speed.toInt())
//                    _uvIndex.postValue(it.uvi)
//                    _humidity.postValue(it.humidity)
//                    showUV.value = it.uvi > 0.0
//                    Timber.d("tuna: showUV ${showUV.value}")
//                    _pressure.postValue(it.pressure)
//                    weatherRepository.deleteLocalWeather()
//                    weatherRepository.insertWeatherToDB(weather)
//                }
//
//                _listHourlyForecast.postValue(
//                    weather.hourly?.filter { it.dt < tomorrow.timeInMillis / 1000 }
//                        ?.map {
//                            HourlyItemUI(
//                                hourly = it,
//                                timeZone = weather.timezone,
//                                onClick = { item ->
//                                    hourlyCallback?.onHourlyItemClick(item)
//                                },
//                            )
//                        },
//                )
//                _listDailyForecast.postValue(
//                    weather.daily?.map {
//                        DailyItemUI(
//                            daily = it,
//                            onClick = { item ->
//                                dailyCallback?.onDailyItemClick(item)
//                            },
//                        )
//                    },
//                )
//                Timber.d("Weather: $weather")
//                hasData.value = true
//                delay(500L)
//                showLoading.value = false
//            } catch (e: Exception) {
//                hasData.value = false
//                _errorMessage.value = e.message
//                showErrorDialog.value = true
//                Timber.e("tuna: ${e.message}")
//            }
//        }
//        _dateTime.value = SimpleDateFormat("EEE, d MMM, ", Locale.getDefault()).format(Date())
//    }
//
//    fun navigateHomeToLocation() {
//        navigate(
//            NavigationCommand.To(
//                HomeFragmentDirections.actionHomeFragmentToLocationFragment(),
//            ),
//        )
//    }
//
//    fun navigateHomeToDaily() {
//        navigate(
//            NavigationCommand.To(
//                HomeFragmentDirections.actionHomeFragmentToDailyFragment(),
//            ),
//        )
//    }
//
//    fun navigateHomeToSetting() {
//        navigate(
//            NavigationCommand.To(
//                HomeFragmentDirections.actionHomeFragmentToSettingFragment(),
//            ),
//        )
//    }
//
//    fun navigateLocationToAddLocation() {
//        navigate(
//            NavigationCommand.To(
//                LocationFragmentDirections.actionLocationFragmentToAddLocationFragment(),
//            ),
//        )
//    }
//
//    fun navigateSplashToHome() {
//        viewModelScope.launch {
//            delay(500L)
//            navigate(
//                NavigationCommand.To(
//                    SplashFragmentDirections.actionSplashFragmentToHomeFragment(),
//                ),
//            )
//        }
//    }
//
//    fun hasLocationPermission() {
//        _hasLocationPermission.value = true
//    }
//
//    fun updateLocation(lat: Double, lon: Double) {
//        _latitude.value = lat
//        _longitude.value = lon
// //        initData()
//    }

    interface HourlyCallback {
        fun onHourlyItemClick(item: HourlyItemUI)
    }

    interface DailyCallback {
        fun onDailyItemClick(item: DailyItemUI)
    }
}
