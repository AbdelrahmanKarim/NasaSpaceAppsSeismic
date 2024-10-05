package com.marwa.abdulrahman_test.network

import com.marwa.abdulrahman_test.model.EarthquakeDataResponse
import com.marwa.abdulrahman_test.model.WeatherForecastResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("WeatherForecast")
    fun getWeatherForecast(): Call<List<WeatherForecastResponse>>


    @GET("Points")
    fun getPoints(): Call<EarthquakeDataResponse>
}