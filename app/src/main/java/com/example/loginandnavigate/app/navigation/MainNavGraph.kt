package com.example.loginandnavigate.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginandnavigate.bottom_navigation_screen.MainScreen
import com.example.loginandnavigate.screen.HomeScreen
import com.example.loginandnavigate.screen.LoginScreen
import com.example.loginandnavigate.screen.SignUpScreen

@Composable
fun MainNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationRoutes.Login.route) {
        composable(NavigationRoutes.Login.route) {
            LoginScreen(
                onNavigateToSignup = {
                    navController.navigate(NavigationRoutes.SignUp.route)
                },
//                onNavigateToHome = {
//                    navController.navigate(NavigationRoutes.Home.route)
//                }
                onNavigateToHome = {
                    // Change this to navigate to MainApp instead
                    navController.navigate(NavigationRoutes.MainApp.route) {
                        // Optional: Clear back stack so user can't go back to login
                        popUpTo(NavigationRoutes.Login.route) { inclusive = true }
                    }
                }
            )
        }

        composable(NavigationRoutes.SignUp.route) {
            SignUpScreen(
                onNavigateToLogin = {
                    navController.navigate(NavigationRoutes.Login.route)
                }
            )
        }

        // Bottom Navigation (Main App)
        composable(NavigationRoutes.MainApp.route) {
            MainScreen() // Loads Bottom Navigation
        }


//        composable(NavigationRoutes.Home.route) {
//            HomeScreen()
//        }
    }
}
