package com.richards.jonathan.weatherapp.data.network.contract

import okhttp3.OkHttpClient

interface NetworkHelperContract {
    fun createHttpClient(): OkHttpClient
}