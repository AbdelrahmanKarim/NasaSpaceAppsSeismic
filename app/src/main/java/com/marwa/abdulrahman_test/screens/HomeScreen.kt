package com.marwa.abdulrahman_test.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.marwa.abdulrahman_test.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)


    ) {
        Image(
            painter = painterResource(id = R.drawable.img_2), // Replace with your moon image resource
            contentDescription = "Moon",
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp)
        )

        Column(


            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical =  32.dp, horizontal = 16.dp)
        ) {
            Column( horizontalAlignment = Alignment.CenterHorizontally,) {
                
                Spacer(modifier = Modifier.size(50.dp))


            Text(text = "Moon",color = Color.White, fontSize = 40.sp , fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.roboto_medium)))
            Text(text = "Unveiling the Moon’s hidden quakes and internal mysteries",color = Color.White, fontSize = 16.sp , fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.roboto_medium)))
            Image(painter = painterResource(id = R.drawable.img_3), contentDescription = "Moon Image")}
            Spacer(modifier = Modifier.size(24.dp))
            Text(text = "Info", Modifier
                .background(Color(0xFF363636), shape = RoundedCornerShape(8.dp))
                .padding(12.dp, 8.dp),
                color = Color(0xFFC98D15))
            Column {
                Text(text = "Total Quakes Detected", color = Color(0xFFAAAAAA))
                Text(text = "3,000+ Moonquakes Recorded", color = Color.White)
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = "Mission Involvement", color = Color(0xFFAAAAAA))
                Text(text = "Apollo 11, 12, 14, 15, and 16 ", color = Color.White)
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = "Last Seismic Event", color = Color(0xFFAAAAAA))
                Text(text = "June 15, 2023", color = Color.White)
                Spacer(modifier = Modifier.size(16.dp))

            }
            Spacer(modifier = Modifier.size(50.dp))
            Button(

                onClick = { navController.navigate("output") },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC98D15),
                    contentColor = Color.White),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Explore Data")
            }
            
            }




        }
    }





    
