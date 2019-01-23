package com.richards.jonathan.weatherapp

import com.richards.jonathan.weatherapp.domain.LocationProvider
import com.richards.jonathan.weatherapp.domain.LocationProviderImpl
import com.richards.jonathan.weatherapp.domain.WeatherRepository
import com.richards.jonathan.weatherapp.domain.usecase.GetCurrentLocationUseCase
import com.richards.jonathan.weatherapp.domain.usecase.GetWeatherInfoUseCase
import org.koin.dsl.module.module
import org.mockito.Mockito

object TestModule {
    fun getTestModules() = module {
        factory(override = true) { GetWeatherInfoUseCase(get()) }
        factory(override = true) { GetCurrentLocationUseCase(get()) }
        single<LocationProvider>(override = true) { Mockito.mock(LocationProvider::class.java) }
        single<WeatherRepository>(override = true) { Mockito.mock(WeatherRepository::class.java) }
    }
}