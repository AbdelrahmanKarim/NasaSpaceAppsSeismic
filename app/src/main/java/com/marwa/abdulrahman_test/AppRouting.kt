package com.marwa.abdulrahman_test

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marwa.abdulrahman_test.screens.HomeScreen
import com.marwa.abdulrahman_test.screens.OutputScreen
import com.marwa.abdulrahman_test.screens.SplashScreen

@Composable
fun AppNavigator(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {

        composable("splash") { SplashScreen(modifier,navController) }
        composable("main") { HomeScreen(modifier,navController)}
        composable("output") { OutputScreen(modifier) } }


}