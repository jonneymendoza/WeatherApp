package com.richards.jonathan.weatherapp.main

import com.richards.jonathan.weatherapp.domain.di.DomainModule
import org.koin.dsl.module.Module

object AppComponent {
    val getAllModules = listOf<Module>(DomainModule.getModule)
}