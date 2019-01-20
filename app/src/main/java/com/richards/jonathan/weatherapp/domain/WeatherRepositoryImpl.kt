package com.richards.jonathan.weatherapp.domain

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.richards.jonathan.weatherapp.data.model.City
import com.richards.jonathan.weatherapp.data.model.WeatherInfo
import com.richards.jonathan.weatherapp.data.network.SingleCallHandler
import com.richards.jonathan.weatherapp.data.network.contract.NetworkControllerContract
import com.richards.jonathan.weatherapp.data.network.entity.Resource
import java.nio.charset.Charset

class WeatherRepositoryImpl constructor(val context: Context, val networkController: NetworkControllerContract) :
    WeatherRepository {

    inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object : TypeToken<T>() {}.type)

    override fun getCityId(cityName: String): MutableLiveData<String> {
        val cityId = MutableLiveData<String>()

        var cityIdString = ""

        val cityList: MutableList<City> = Gson().fromJson<List<City>>(getJsonString()).toMutableList()

        for (city in cityList) {
            if (city.name == cityName) {
                cityIdString = city.id
                break
            }
        }

        cityId.postValue(cityIdString)
        return cityId
    }

    override fun getWeatherInfo(cityId: String): MutableLiveData<Resource<WeatherInfo>> {
        return SingleCallHandler<WeatherInfo>().makeCall(networkController.getWeather())
    }

    private fun getJsonString(): String {
        val inputStream = this.javaClass.classLoader?.getResourceAsStream("city_list.json")
        inputStream?.apply {
            return readBytes().toString(Charset.forName("utf-8"))
        }
    }

}