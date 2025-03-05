package com.example.loginandnavigate.app.navigation

sealed class NavigationRoutes(val route: String) {
    object Login: NavigationRoutes("login")
    object SignUp: NavigationRoutes("signup")
}