package com.example.loginandnavigate.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationRoutes(val route: String) {
    object Login: NavigationRoutes("login")
    object SignUp: NavigationRoutes("signup")
    object Home: NavigationRoutes("home")
    object MainApp : NavigationRoutes("mainApp")
}


sealed class BottomNavItem(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomNavItem("home", "Home", Icons.Default.Home)
    object Search : BottomNavItem("search", "Search", Icons.Default.Search)
    object Profile : BottomNavItem("profile", "Profile", Icons.Default.Person)
}
