package com.example.loginandnavigate.app.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.loginandnavigate.screen.HomeScreen
import com.example.loginandnavigate.screen.bottom_screen.ProfileScreen
import com.example.loginandnavigate.screen.bottom_screen.SearchScreen

@Composable
fun BottomNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    Box(modifier = modifier) { // Apply the padding
        NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
            composable(BottomNavItem.Home.route) { HomeScreen() }
           composable(BottomNavItem.Search.route) { SearchScreen() }
            composable(BottomNavItem.Profile.route) { ProfileScreen() }
        }
    }
}
