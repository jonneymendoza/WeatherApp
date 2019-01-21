package com.richards.jonathan.weatherapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.richards.jonathan.weatherapp.domain.usecase.GetCityIdUseCase
import com.richards.jonathan.weatherapp.domain.usecase.GetCurrentLocationUseCase
import com.richards.jonathan.weatherapp.domain.usecase.GetWeatherInfoUseCase

class WeatherViewModel constructor(
    val getCityIdUseCase: GetCityIdUseCase,
    val getCurrentLocationUseCase: GetCurrentLocationUseCase,
    val getWeatherInfoUseCase: GetWeatherInfoUseCase ) : ViewModel(){

}