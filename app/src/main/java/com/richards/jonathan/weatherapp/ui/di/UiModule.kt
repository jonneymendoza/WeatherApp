package com.richards.jonathan.weatherapp.ui.di

import com.richards.jonathan.weatherapp.ui.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object UiModule {

    val getModule = module {
        viewModel { WeatherViewModel(get(), get()) }
    }
}