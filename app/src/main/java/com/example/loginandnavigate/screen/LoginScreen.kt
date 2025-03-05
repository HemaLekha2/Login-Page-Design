package com.example.loginandnavigate.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.loginandnavigate.R
import com.example.loginandnavigate.components.ClickableLoginTextComponent
import com.example.loginandnavigate.components.DividerTextComponent
import com.example.loginandnavigate.components.GradientButton
import com.example.loginandnavigate.components.HeadingTextComponent
import com.example.loginandnavigate.components.MyTextFieldComponent
import com.example.loginandnavigate.components.NormalTextComponent
import com.example.loginandnavigate.components.PasswordTextFieldComponent
import com.example.loginandnavigate.components.UnderLinedTextComponent

@Composable
fun LoginScreen(onNavigateToSignup: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            NormalTextComponent(value = stringResource(id = R.string.login))
            HeadingTextComponent(value = stringResource(id = R.string.welcome))

            Spacer(modifier = Modifier.height(20.dp))
            MyTextFieldComponent(labelValue = stringResource(R.string.email), painterResource = Icons.Default.Email)
            PasswordTextFieldComponent(labelValue = stringResource(R.string.password), painterResource = Icons.Default.Lock)

            Spacer(modifier = Modifier.height(40.dp))
            UnderLinedTextComponent(value = stringResource(R.string.forgot_password))

            Spacer(modifier = Modifier.height(40.dp))
            GradientButton(value = stringResource(id = R.string.login), onClick = {})


            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()

            Spacer(modifier = Modifier.height(20.dp))
            ClickableLoginTextComponent(
                normalText = "Don't have an account? ",
                clickableText = "Register"
            ) { clickedText ->
                if (clickedText == "Register") {
                    onNavigateToSignup()  // Navigate to Signup screen
                }
            }
        }
    }
}

