package com.marwa.abdulrahman_test.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import com.marwa.abdulrahman_test.MainActivity
import com.marwa.abdulrahman_test.R
import com.marwa.abdulrahman_test.getFromJson
import org.json.JSONObject
import kotlin.io.path.Path
import kotlin.io.path.moveTo

@Composable
fun OutputScreen(modifier: Modifier = Modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_4), // Replace with your moon image resource
                contentDescription = "Moon",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 32.dp)
                    //.graphicsLayer(alpha=0.5f)
                    //, colorFilter = ColorFilter.tint(Color.Black)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { /* Handle back button click */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = "Analyzing",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(16.dp))

                }

                Spacer(modifier = Modifier.height(16.dp))

                viewPoints()



                Spacer(modifier = Modifier.height(50.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box (
                        modifier= Modifier
                            .background(color = Color(0xFF1E1E1EB2))
                            .padding(8.dp)

                    ){
                        Column {
                            Text(
                                text = "20 s",
                                fontSize = 32.sp,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White
                            )
                            Text(text ="Event Duration" ,color = Color(0xFFC98D15
                                    ))
                        }


                    }
                    Spacer(modifier = Modifier.size( 16.dp))
                    
                    Box (
                        modifier= Modifier
                            .background(color = Color(0xFF1E1E1EB2))
                            .padding(8.dp)

                    ){
                        Column {
                            Text(
                                text = "1.4 m/s^2",
                                fontSize = 32.sp,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White
                            )
                            Text(text ="Velocity Rate", color = Color(0xFFC98D15
                            ) )
                        }


                    }

                }
            }
        }
    }

@Composable
private fun viewPoints() {
    val context = LocalContext.current
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
        //.backgroundColor(Color.Blue)
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
                    LineStyle(color = Color(0xFFC98D15)),
                    IntersectionPoint(Color(0xFFC98D15), radius =  1.dp),
                    SelectionHighlightPoint(radius = 1.dp,  color = Color(0xFFC98D15)),
                    ShadowUnderLine(),
                    SelectionHighlightPopUp()
                ),

                Line(
                    dataPoints = vPoints,
                    LineStyle(color = Color.Red),
                    IntersectionPoint(Color.Red, radius =  1.dp),
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


Box (Modifier.background(Color.Transparent)){


    LineChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        lineChartData = lineChartData
    )}

}

//    @Composable
//    fun LineGraph(data: List<Float>, color: Color) {
//        val path = Path().apply {
//            moveTo(0f, 0f)
//            data.forEachIndexed { index, value ->
//                val x = index.toFloat() * 20.dp
//                val y = (value / 2.0f) * height.dp
//                lineTo(x, y)
//            }
//        }
//
//        Canvas(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//        ) {
//            drawLine(
//                path = path,
//                color = color,
//                strokeWidth = 2.dp
//            )
//
//
//        }
//
//
//
//}