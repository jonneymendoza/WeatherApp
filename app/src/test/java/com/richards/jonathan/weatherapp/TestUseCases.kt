package com.richards.jonathan.weatherapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.jraska.livedata.test
import com.richards.jonathan.weatherapp.data.LocationState
import com.richards.jonathan.weatherapp.data.UserLocation
import com.richards.jonathan.weatherapp.data.model.MainWeather
import com.richards.jonathan.weatherapp.data.model.Weather
import com.richards.jonathan.weatherapp.data.model.WeatherInfo
import com.richards.jonathan.weatherapp.data.model.Wind
import com.richards.jonathan.weatherapp.data.network.entity.Resource
import com.richards.jonathan.weatherapp.data.network.entity.Status
import com.richards.jonathan.weatherapp.domain.LocationProvider
import com.richards.jonathan.weatherapp.domain.WeatherRepository
import com.richards.jonathan.weatherapp.domain.usecase.GetCurrentLocationUseCase
import com.richards.jonathan.weatherapp.domain.usecase.GetWeatherInfoUseCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.standalone.StandAloneContext.loadKoinModules
import org.koin.standalone.inject
import org.koin.test.KoinTest
import org.mockito.Mockito

class TestUseCases : KoinTest {

    companion object {
        private const val TEMPERATURE = 12.0
    }

    val getCurrentLocationUseCase: GetCurrentLocationUseCase by inject()
    val getWeatherInfoUseCase: GetWeatherInfoUseCase by inject()
    val locationProvider: LocationProvider by inject()
    val weatherRepository: WeatherRepository by inject()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        loadKoinModules(listOf(TestModule.getTestModules()))

    }

    @Test
    fun testGetLocationUseCase() {

        Mockito.`when`(locationProvider.getLocation()).thenReturn(
            locationResult()
        )

        getCurrentLocationUseCase.getLocation().test()
            .awaitValue()
            .assertValue { location ->
                location.state == LocationState.SUCCESS
            }
            .assertValue { location ->
                location.errorMessages.isNullOrEmpty()
            }
            .assertValue { location ->
                location.lat == 1234.1
            }
            .assertValue { location -> location.lon == 1234.2 }
    }

    private fun locationResult(): MutableLiveData<UserLocation>? {
        val result = MutableLiveData<UserLocation>()
        result.postValue(UserLocation(1234.1, 1234.2, LocationState.SUCCESS, null))
        return result
    }

    @Test
    fun testGetWeatherInfo() {
        Mockito.`when`(weatherRepository.getWeatherInfo(1234.1, 1234.2))
            .thenReturn(
                getMockedData()
            )
        getWeatherInfoUseCase.getWeatherInfo(1234.1, 1234.2).test()
            .awaitValue()
            .assertValue { resource ->
                resource.status == Status.SUCCESS
            }
            .assertValue { resource ->
                resource.data != null
            }
            .assertValue { resource ->
                resource.data!!.main.temp == TEMPERATURE
            }

    }

    private fun getMockedData(): MutableLiveData<Resource<WeatherInfo>> {
        val mockedLiveData = MutableLiveData<Resource<WeatherInfo>>()
        val weatherItem = Weather("1234", "Clouds", "clouds gathering", "icon")
        val mainWeather = MainWeather(Companion.TEMPERATURE, 5, 10.0, 7.2, 13.2)
        val wind = Wind(23.0)
        val data = WeatherInfo(listOf(weatherItem), mainWeather, wind)

        val resource = Resource<WeatherInfo>(Status.SUCCESS, data, null)

        mockedLiveData.postValue(resource)
        return mockedLiveData
    }


}