package com.richards.jonathan.weatherapp

import com.richards.jonathan.weatherapp.domain.LocationProvider
import com.richards.jonathan.weatherapp.domain.LocationProviderImpl
import com.richards.jonathan.weatherapp.domain.WeatherRepository
import com.richards.jonathan.weatherapp.domain.WeatherRepositoryImpl
import com.richards.jonathan.weatherapp.domain.usecase.GetCurrentLocationUseCase
import com.richards.jonathan.weatherapp.domain.usecase.GetWeatherInfoUseCase
import org.koin.dsl.module.module
import org.mockito.Mockito

object TestModule {
    fun getTestModules() = module {
        factory<WeatherRepository> { Mockito.mock(WeatherRepositoryImpl::class.java) }
        factory { GetWeatherInfoUseCase(get()) }
        factory { GetCurrentLocationUseCase(get()) }
        factory<LocationProvider> { Mockito.mock(LocationProviderImpl::class.java) }
    }
}