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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.loginandnavigate.R
import com.example.loginandnavigate.components.CheckboxComponent
import com.example.loginandnavigate.components.ClickableLoginTextComponent
import com.example.loginandnavigate.components.DividerTextComponent
import com.example.loginandnavigate.components.GradientButton
import com.example.loginandnavigate.components.HeadingTextComponent
import com.example.loginandnavigate.components.MyTextFieldComponent
import com.example.loginandnavigate.components.NormalTextComponent
import com.example.loginandnavigate.components.PasswordTextFieldComponent

@Composable
fun SignUpScreen(onNavigateToLogin: () -> Unit) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize().padding(28.dp)
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(28.dp),
        ) {
            NormalTextComponent(value = stringResource(R.string.hello))
            HeadingTextComponent(value = stringResource(R.string.Create_account))
            Spacer(modifier = Modifier.height(20.dp))
            // ✅ Pass Material Icons
            MyTextFieldComponent(labelValue = stringResource(R.string.first_name), painterResource = Icons.Default.Person)
            MyTextFieldComponent(labelValue = stringResource(R.string.last_name), painterResource = Icons.Default.Person)
            MyTextFieldComponent(labelValue = stringResource(R.string.email), painterResource = Icons.Default.Email)
          //MyTextFieldComponent(labelValue = stringResource(R.string.password), painterResource = Icons.Default.Lock) // 🔐 Password Field
            PasswordTextFieldComponent(labelValue = stringResource(R.string.password), painterResource = Icons.Default.Lock)
             CheckboxComponent()
             Spacer(modifier = Modifier.height(40.dp))
            GradientButton(value = " Login ", onClick = {  })

            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()

            ClickableLoginTextComponent(
                normalText = "Already have an account? ",
                clickableText = "Login"
            ) { clickedText ->
                if (clickedText == "Login") {
                    onNavigateToLogin() // Navigate to Login screen
                }
            }
        }
    }
}


