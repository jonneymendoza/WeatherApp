package com.richards.jonathan.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.richards.jonathan.weatherapp.data.UserLocation
import com.richards.jonathan.weatherapp.data.model.WeatherInfo
import com.richards.jonathan.weatherapp.data.network.entity.Resource
import com.richards.jonathan.weatherapp.domain.usecase.GetCurrentLocationUseCase
import com.richards.jonathan.weatherapp.domain.usecase.GetWeatherInfoUseCase

class WeatherViewModel constructor(
    val getCurrentLocationUseCase: GetCurrentLocationUseCase,
    val getWeatherInfoUseCase: GetWeatherInfoUseCase
) : ViewModel() {

    private var weatherInfo = MutableLiveData<Resource<WeatherInfo>>()

    fun getCurrentLocation(): MutableLiveData<UserLocation> {
        return getCurrentLocationUseCase.getLocation()
    }

    fun fetchCurrentWeather(lat: Double, lon: Double): MutableLiveData<Resource<WeatherInfo>> {
        weatherInfo = getWeatherInfoUseCase.getWeatherInfo(lat, lon)
        return weatherInfo
    }

    fun getCurrentWeatherLiveData(): MutableLiveData<Resource<WeatherInfo>> {
        return weatherInfo
    }


}