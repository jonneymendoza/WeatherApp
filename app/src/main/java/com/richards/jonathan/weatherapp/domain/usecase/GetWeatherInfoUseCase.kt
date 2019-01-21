package com.richards.jonathan.weatherapp.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.richards.jonathan.weatherapp.data.model.WeatherInfo
import com.richards.jonathan.weatherapp.data.network.entity.Resource
import com.richards.jonathan.weatherapp.domain.WeatherRepository

class GetWeatherInfoUseCase constructor(private val weatherRepository: WeatherRepository) {

    fun getWeatherInfo(lat: Long, lon: Long): MutableLiveData<Resource<WeatherInfo>> {
        return weatherRepository.getWeatherInfo(lat,lon)
    }
}