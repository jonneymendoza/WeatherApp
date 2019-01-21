package com.richards.jonathan.weatherapp.domain

import androidx.lifecycle.MutableLiveData
import com.richards.jonathan.weatherapp.data.model.WeatherInfo
import com.richards.jonathan.weatherapp.data.network.entity.Resource

interface WeatherRepository {
    fun getWeatherInfo(cityId: String): MutableLiveData<Resource<WeatherInfo>>
    fun getCityId(cityName: String): MutableLiveData<String>
}