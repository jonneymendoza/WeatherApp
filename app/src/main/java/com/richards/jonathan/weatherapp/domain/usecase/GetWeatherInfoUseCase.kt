package com.richards.jonathan.weatherapp.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.richards.jonathan.weatherapp.data.model.WeatherInfo
import com.richards.jonathan.weatherapp.data.network.entity.Resource

class GetWeatherInfoUseCase {

    fun getWeatherInfo(cityId: String): MutableLiveData<Resource<WeatherInfo>> {
        //TODO
    }
}