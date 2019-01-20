package com.richards.jonathan.weatherapp.data.network.di

import com.richards.jonathan.weatherapp.data.network.NetworkController
import com.richards.jonathan.weatherapp.data.network.NetworkHelper
import com.richards.jonathan.weatherapp.data.network.contract.NetworkControllerContract
import com.richards.jonathan.weatherapp.data.network.contract.NetworkHelperContract
import org.koin.dsl.module.module

object NetworkModule {

    val getModule = module {
        single<NetworkControllerContract> { NetworkController(get()) }
        single<NetworkHelperContract> { NetworkHelper() }
    }
}