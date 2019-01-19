package com.richards.jonathan.weatherapp.domain.di

import com.richards.jonathan.weatherapp.domain.LocationProvider
import com.richards.jonathan.weatherapp.domain.LocationProviderImpl
import com.richards.jonathan.weatherapp.domain.usecase.GetCityIdUseCase
import com.richards.jonathan.weatherapp.domain.usecase.GetCurrentLocationUseCase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

object DomainModule {

    val getModule = module {
        factory<LocationProvider> { LocationProviderImpl(androidApplication()) }
        factory { GetCurrentLocationUseCase(get()) }
        factory { GetCityIdUseCase() }
    }
}