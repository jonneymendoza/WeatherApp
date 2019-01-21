package com.richards.jonathan.weatherapp.main

import com.richards.jonathan.weatherapp.data.network.di.NetworkModule
import com.richards.jonathan.weatherapp.domain.di.DomainModule
import com.richards.jonathan.weatherapp.ui.di.UiModule

object AppComponent {
    val getAllModules = listOf(
        DomainModule.getModule,
        NetworkModule.getModule,
        UiModule.getModule
    )
}