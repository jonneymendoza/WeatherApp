package com.richards.jonathan.weatherapp.domain.usecase

import androidx.lifecycle.MutableLiveData

class GetCityIdUseCase {

    private var cityIdLiveData = MutableLiveData<String>()

    fun getCityId(): MutableLiveData<String> {

        //TODO
        return cityIdLiveData
    }
}