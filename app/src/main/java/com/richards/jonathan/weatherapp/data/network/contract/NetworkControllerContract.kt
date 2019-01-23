package com.richards.jonathan.weatherapp.data.network.contract

import com.richards.jonathan.weatherapp.data.model.WeatherInfo
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface NetworkControllerContract {
    fun getWeather(lat: Double, lon: Double): Deferred<Response<WeatherInfo>>
}