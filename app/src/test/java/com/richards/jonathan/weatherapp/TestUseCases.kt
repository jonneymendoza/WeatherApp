package com.richards.jonathan.weatherapp

import android.location.Location
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.richards.jonathan.weatherapp.data.LocationState
import com.richards.jonathan.weatherapp.data.UserLocation
import com.richards.jonathan.weatherapp.data.model.WeatherInfo
import com.richards.jonathan.weatherapp.data.network.entity.Resource
import com.richards.jonathan.weatherapp.domain.LocationProvider
import com.richards.jonathan.weatherapp.domain.WeatherRepository
import com.richards.jonathan.weatherapp.domain.usecase.GetCurrentLocationUseCase
import com.richards.jonathan.weatherapp.domain.usecase.GetWeatherInfoUseCase
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule
import org.koin.standalone.StandAloneContext.loadKoinModules
import org.koin.standalone.inject
import org.koin.test.KoinTest
import org.mockito.Mockito

class TestUseCases : KoinTest {

    val getCurrentLocationUseCase: GetCurrentLocationUseCase by inject()
    val getWeatherInfoUseCase: GetWeatherInfoUseCase by inject()
    val locationProvider: LocationProvider by inject()
    val weatherRepository: WeatherRepository by inject()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        loadKoinModules(listOf(TestModule.getTestModules()))

        val location = Mockito.mock(Location::class.java)
        Mockito.`when`(location.latitude).thenReturn(1234.1)
        Mockito.`when`(location.longitude).thenReturn(1234.1)
        Mockito.`when`(locationProvider.getLocation()).then {

            UserLocation(location, LocationState.SUCCESS, null)
        }

        Mockito.`when`(weatherRepository.getWeatherInfo(location.latitude.toLong(), location.longitude.toLong()))
            .thenReturn(
                getMockedData()
            )


    }

    private fun getMockedData(): MutableLiveData<Resource<WeatherInfo>> {

    }

}