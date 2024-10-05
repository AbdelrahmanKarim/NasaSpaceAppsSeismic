package com.marwa.abdulrahman_test

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.marwa.abdulrahman_test.ui.theme.Abdulrahman_TestTheme
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Abdulrahman_TestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigator( modifier = Modifier.padding(innerPadding))
                    /*viewPoints(
                        this@MainActivity,
                        modifier = Modifier.padding(innerPadding)
                    )*/
                }
            }
        }
    }
}

private val TAG = "MainActivity"

@Composable
fun GetData(modifier: Modifier = Modifier) {
//    RetrofitClient.getApiService().getWeatherForecast().enqueue(object :
//        Callback<List<WeatherForecastResponse>> {
//        override fun onResponse(
//            call: Call<List<WeatherForecastResponse>>,
//            response: Response<List<WeatherForecastResponse>>
//        ) {
//            if (response.isSuccessful) {
//                Log.d(TAG, "onResponse: ${response.body()}")
//            }
//        }
//
//        override fun onFailure(p0: Call<List<WeatherForecastResponse>>, p1: Throwable) {
//            Log.e(TAG, "onFailure: ")
//        }
//    })

//    RetrofitClient.getApiService().getPoints().enqueue(object : Callback<EarthquakeDataResponse> {
//        override fun onResponse(
//            call: Call<EarthquakeDataResponse>,
//            response: Response<EarthquakeDataResponse>
//        ) {
//            if (response.isSuccessful) {
//                val response = response.body()!!
//                viewPoints()
//            }
//        }
//
//        override fun onFailure(p0: Call<EarthquakeDataResponse>, p1: Throwable) {
//            Log.e(TAG, "onFailure: ")
//        }
//    })
}

fun getFromJson(context: Context): String? {
    var json: String? = null
    try {
        val inputStream = context.assets.open("data.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        json = String(buffer, charset = Charset.defaultCharset())
    } catch (e: IOException) {
        return null
    }
    return json
}


@Composable
private fun viewPoints(context: Context, modifier: Modifier) {
    var json = getFromJson(context)
    val jsonObject = JSONObject(json)
    val pointsData = jsonObject.getJSONArray("dataPoints")
    val earthquakeTimeData = jsonObject.getDouble("earthquakeTime").toFloat()
//    println(pointsData)
//    println(earthquakeTimeData)
    val steps = 20
    val points: ArrayList<Point> = arrayListOf<Point>()
    val vPoints: ArrayList<Point> = arrayListOf<Point>()
    for (i in 0..<pointsData.length()) {
        var obj = pointsData.getJSONObject(i)
        points.add(
            Point(
                obj.getDouble("timeInSeconds").toFloat(),
                obj.getDouble("velocity").toFloat()
            )
        )

        vPoints.add(
            Point(
                earthquakeTimeData,
                obj.getDouble("velocity").toFloat()
            )
        )

    }
    val xAxisData = AxisData.Builder()
        .axisStepSize(100.dp)
       // .backgroundColor(Color.Blue)
        .steps(points.size - 1)
        .labelData { i -> i.toString() }
        .labelAndAxisLinePadding(15.dp)
        .build()

    val yAxisData = AxisData.Builder()
        .steps(steps)
        //.backgroundColor(Color.Red)
        .labelAndAxisLinePadding(20.dp)
        .labelData { i ->
            val yScale = 100 / steps
            (i * yScale).toString()
        }.build()

    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = points,
                    LineStyle(),
                    IntersectionPoint(),
                    SelectionHighlightPoint(radius = 3.dp),
                    ShadowUnderLine(),
                    SelectionHighlightPopUp()
                ),

                Line(
                    dataPoints = vPoints,
                    LineStyle(color = Color.Red),
                    IntersectionPoint(Color.Red, radius =  2.dp),
                    SelectionHighlightPoint(),
                    ShadowUnderLine(),
                    SelectionHighlightPopUp()
                ),

                ),
        ),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(),
        backgroundColor = Color.Transparent
    )



    LineChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        lineChartData = lineChartData
    )

}


