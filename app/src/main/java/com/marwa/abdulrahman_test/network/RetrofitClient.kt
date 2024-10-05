package com.marwa.abdulrahman_test.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private fun getRetrofit():Retrofit = Retrofit.Builder().baseUrl("https://quakesphere-hfbfa5e0a3ducufd.germanywestcentral-01.azurewebsites.net/").addConverterFactory(GsonConverterFactory.create()).build()

    fun getApiService():ApiService = getRetrofit().create(ApiService::class.java);
}