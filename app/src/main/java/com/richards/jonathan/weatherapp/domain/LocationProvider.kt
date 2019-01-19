package com.richards.jonathan.weatherapp.domain

import androidx.lifecycle.MutableLiveData
import com.richards.jonathan.weatherapp.data.UserLocation

interface LocationProvider {
    fun getLocation(): MutableLiveData<UserLocation>
}