package com.sample.estruturabasica

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Define as telas do aplicativo como objetos
sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object About : Screen("about")
    object Contact : Screen("contact")
}

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        // A função NavHost é responsável por gerenciar a navegação entre as telas
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.About.route) {
            AboutScreen(navController)
        }
        composable(Screen.Contact.route) {
            ContactScreen(navController)
        }
    }
}