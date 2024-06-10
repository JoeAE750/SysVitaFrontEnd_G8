package com.fisi.sysvita.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fisi.sysvita.ui.view.HomeScreen
import com.fisi.sysvita.ui.view.LoginScreen

@Composable
fun SysVitaApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = SysVitaScreen.Home.name,
    ) {
        composable(route = SysVitaScreen.Home.name) {
            HomeScreen()
        }
        composable(route = SysVitaScreen.Login.name) {
            val context = LocalContext.current
            LoginScreen()
        }
    }
}