package com.richards.jonathan.weatherapp.domain.usecase

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.richards.jonathan.weatherapp.data.UserLocation
import com.richards.jonathan.weatherapp.domain.LocationProvider

class GetCurrentLocationUseCase constructor(val locationProvider: LocationProvider) {


    fun getLocation(context: Context): MutableLiveData<UserLocation> {
        return locationProvider.getLocation()
    }
}