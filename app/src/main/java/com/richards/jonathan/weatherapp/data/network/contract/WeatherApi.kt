package com.richards.jonathan.weatherapp.data.network.contract

import com.richards.jonathan.weatherapp.data.model.WeatherInfo
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    companion object {
        const val PARAM_API_KEY = "appid"
        const val PARAM_LAT = "lat"
        const val PARAM_LON = "lon"
    }

    @GET("weather")
    fun getWeather(
        @Query(PARAM_LAT) lat: Long,
        @Query(PARAM_LON) lon: Long,
        @Query(PARAM_API_KEY) appid: String
    ): Deferred<Response<WeatherInfo>>


}