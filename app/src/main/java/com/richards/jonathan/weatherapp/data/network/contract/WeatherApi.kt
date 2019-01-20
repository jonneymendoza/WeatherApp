package com.richards.jonathan.weatherapp.data.network.contract

import com.richards.jonathan.weatherapp.data.model.WeatherInfo
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {

    @GET("/get")
    fun getWeather(): Deferred<Response<WeatherInfo>>


}