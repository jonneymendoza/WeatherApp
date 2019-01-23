package com.richards.jonathan.weatherapp.data.model

data class WeatherInfo(
    val weather: List<Weather>,
    val main: MainWeather,
    val wind: Wind,
    val name : String
)