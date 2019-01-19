package com.richards.jonathan.weatherapp.data.model

data class MainWeather(
    val temp: Double,
    val humidity: Int,
    val pressure: Double,
    val temp_min: Double,
    val temp_max: Double
)