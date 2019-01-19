package com.richards.jonathan.weatherapp.data

import android.location.Location

data class UserLocation(var location: Location?, var state: LocationState, var errorMessages: String?)