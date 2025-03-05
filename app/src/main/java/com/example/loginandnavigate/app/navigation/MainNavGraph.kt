package com.example.loginandnavigate

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginandnavigate.app.navigation.NavigationRoutes
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
    }
}
