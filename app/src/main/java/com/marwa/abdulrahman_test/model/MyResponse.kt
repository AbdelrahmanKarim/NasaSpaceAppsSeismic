package com.marwa.abdulrahman_test.model

import com.google.gson.annotations.SerializedName

data class EarthquakeDataResponse(
    @SerializedName("FileName") val fileName: String,
    @SerializedName("DataPoints") val dataPoints: List<DataPoint> = listOf(),
    @SerializedName("EarthquakeTime") val earthquakeTime: Double
)

data class DataPoint(
    @SerializedName("TimeInSeconds") val timeInSeconds: Double,
    @SerializedName("Velocity") val velocity: Double
)


