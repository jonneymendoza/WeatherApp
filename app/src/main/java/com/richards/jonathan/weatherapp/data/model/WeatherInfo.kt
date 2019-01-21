package com.richards.jonathan.weatherapp.data.model

data class WeatherInfo(
    val weather: Weather,
    val main: MainWeather,
    val wind: Wind
)