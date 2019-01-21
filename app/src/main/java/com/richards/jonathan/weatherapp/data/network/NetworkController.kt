package com.richards.jonathan.weatherapp.data.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.richards.jonathan.weatherapp.BuildConfig
import com.richards.jonathan.weatherapp.data.model.WeatherInfo
import com.richards.jonathan.weatherapp.data.network.contract.NetworkControllerContract
import com.richards.jonathan.weatherapp.data.network.contract.NetworkHelperContract
import com.richards.jonathan.weatherapp.data.network.contract.WeatherApi
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkController constructor(private val networkHelper: NetworkHelperContract) :
    NetworkControllerContract {

    private fun weatherApi(): WeatherApi {
        val gson = GsonBuilder().setLenient().create()
        val httpClient = networkHelper.createHttpClient()
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        return retrofit.create(WeatherApi::class.java)
    }

    override fun getWeather(lat: Long, lon: Long): Deferred<Response<WeatherInfo>> {
        return weatherApi().getWeather(lat,lon, BuildConfig.APP_ID)
    }


}