package com.richards.jonathan.weatherapp.domain

import android.content.Context
import android.location.Location
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.richards.jonathan.weatherapp.data.LocationState
import com.richards.jonathan.weatherapp.data.UserLocation

class LocationProviderImpl constructor(val context: Context) : LocationProvider {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    private var locationLiveData = MutableLiveData<UserLocation>()

    override fun getLocation(): MutableLiveData<UserLocation> {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
        locationLiveData.postValue(UserLocation(0.0, 0.0, LocationState.PENDING, null))

        try {
            fusedLocationProviderClient.lastLocation.addOnSuccessListener { location: Location? ->
                locationLiveData.postValue(
                    UserLocation(
                        location!!.latitude,
                        location!!.longitude,
                        LocationState.SUCCESS,
                        null
                    )
                )
            }

        } catch (e: SecurityException) {
            e.printStackTrace()
            locationLiveData.postValue(UserLocation(0.0, 0.0, LocationState.ERROR, "Permissions not set"))
        }
        return locationLiveData

    }

}