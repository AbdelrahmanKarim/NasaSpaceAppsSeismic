package com.marwa.abdulrahman_test.model

import com.google.gson.annotations.SerializedName

data class WeatherForecastResponse(
    @SerializedName("date") val date: String,
    @SerializedName("temperatureC") val tempC: Double,
    @SerializedName("temperatureF") val tempF: Double,
    @SerializedName("summary") val summary:String
)

