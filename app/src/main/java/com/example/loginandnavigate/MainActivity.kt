package com.example.loginandnavigate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.loginandnavigate.app.navigation.MainNavGraph
import com.example.loginandnavigate.ui.theme.LoginAndNavigateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // 🚀 Install the splash screen before calling super.onCreate()
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Optionally, you can keep the splash screen longer based on conditions
        splashScreen.setKeepOnScreenCondition { false }  // Modify this if needed
        setContent {
            LoginAndNavigateTheme {
                MainNavGraph()
            }
        }
    }
}

