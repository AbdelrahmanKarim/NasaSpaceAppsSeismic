package com.marwa.abdulrahman_test.screens

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.marwa.abdulrahman_test.AppNavigator
import com.marwa.abdulrahman_test.R

@Composable
fun SplashScreen(modifier: Modifier = Modifier,navController: NavController) {


    Box(modifier.fillMaxSize()
        
    ){
        Image(painter = painterResource(id = R.drawable.img_1),
            contentDescription = "Quakespherebackground"
                ,Modifier.fillMaxSize()
                , contentScale = ContentScale.Crop

        )
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    , verticalArrangement = Arrangement.SpaceBetween) {

        Column (modifier = Modifier.padding(top = 24.dp)){
            Spacer(modifier = Modifier.size(50.dp))

            Row(verticalAlignment = Alignment.Top) {

                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Quakesphere logo",
                    Modifier.size(40.dp)
                )
                Text(text = "UAKESPHERE", color = Color.White, fontSize = 40.sp, fontFamily = FontFamily(Font(R.font.poppins_bold)))
            }

            Text(text = "Let’s explore the seismic heartbeat of distant worlds to unlock planetary secrets!", color = Color.White, fontFamily = FontFamily(Font(R.font.roboto_medium)))

        }
        Box() {


            Button(
                onClick = { navController.navigate("main") },
                modifier = Modifier.padding(bottom = 24.dp)
               , colors = ButtonDefaults.buttonColors(containerColor = Color.White,
                    contentColor = Color(0xFFC98D15)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Get Started",
                    )

            }


        }
    }


    }





}


