package com.example.loginandnavigate.bottom_navigation_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.loginandnavigate.app.navigation.BottomNavGraph
import com.example.loginandnavigate.app.navigation.BottomNavigationBar

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        BottomNavGraph(navController, Modifier.padding(paddingValues)) // Apply padding
    }
}
