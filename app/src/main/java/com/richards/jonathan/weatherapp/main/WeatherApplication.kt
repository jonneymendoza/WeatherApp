package com.richards.jonathan.weatherapp.main

import android.app.Application
import org.koin.android.ext.android.startKoin

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, AppComponent.getAllModules)
    }
}