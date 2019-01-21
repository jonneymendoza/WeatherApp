package com.richards.jonathan.weatherapp.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.richards.jonathan.weatherapp.domain.WeatherRepository

class GetCityIdUseCase constructor(private val weatherRepository: WeatherRepository) {

    private var cityIdLiveData = MutableLiveData<String>()

    fun getCityId(cityName: String): MutableLiveData<String> {
        cityIdLiveData = weatherRepository.getCityId(cityName)
        return cityIdLiveData
    }
}