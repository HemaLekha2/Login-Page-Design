package com.example.loginandnavigate.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginandnavigate.R
import com.example.loginandnavigate.ui.theme.PgColor
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import com.example.loginandnavigate.ui.theme.GrayColor
import com.example.loginandnavigate.ui.theme.Primary
import com.example.loginandnavigate.ui.theme.Secondary



@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}
@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@Composable
fun MyTextFieldComponent(labelValue: String,painterResource: ImageVector?) {
    val textValue = remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(PgColor), // ✅ Added Background Color
        value = textValue.value,
        onValueChange = { textValue.value = it },
        label = { Text(text = labelValue) },
        leadingIcon = {
            painterResource?.let { // ✅ Show icon only if provided
                Icon(
                    imageVector = it,
                    contentDescription = "Icon",
                    tint = colorResource(id = R.color.colorPrimary)
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            unfocusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            unfocusedContainerColor = PgColor,  // ✅ Background Color for TextField
            focusedContainerColor = PgColor     // ✅ Background Color when focused
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
    )
}

@Composable
fun PasswordTextFieldComponent(labelValue: String, painterResource: ImageVector?) {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(PgColor),
        value = password,
        onValueChange = { password = it },
        label = { Text(text = labelValue) },
        leadingIcon = {
            painterResource?.let {
                Icon(
                    imageVector = it,
                    contentDescription = "Icon",
                    tint = colorResource(id = R.color.colorPrimary)
                )
            }
        },
        trailingIcon = {
            val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, contentDescription = description)
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            unfocusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            unfocusedContainerColor = PgColor,
            focusedContainerColor = PgColor
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun CheckboxComponent() {
    var checkedState by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = { checkedState = it }
        )

        Spacer(modifier = Modifier.width(8.dp)) // Space between checkbox and text

        ClickableTextComponent(
            onPrivacyPolicyClick = { Log.d("onPrivacyPolicyClick", "Privacy Policy Clicked") },
            onTermsClick = { Log.d("onTermsClick", "Terms of Use Clicked") }
        )
    }
}

@Composable
fun ClickableTextComponent(onPrivacyPolicyClick: () -> Unit, onTermsClick: () -> Unit) {
    val initialText = "By continuing, you accept our "
    val privacyPolicyText = "Privacy Policy"
    val andText = " and "
    val termsAndConditionsText = "Terms of Use"

    val annotatedString = buildAnnotatedString {
        append(initialText)

        // Privacy Policy (Clickable)
        addStyle(
            style = SpanStyle(color = Primary, fontSize = 14.sp),
            start = length,
            end = length + privacyPolicyText.length
        )
        addStringAnnotation(
            tag = "PRIVACY_POLICY",
            annotation = "privacy",
            start = length,
            end = length + privacyPolicyText.length
        )
        append(privacyPolicyText)

        append(andText)

        // Terms of Use (Clickable)
        addStyle(
            style = SpanStyle(color = Primary, fontSize = 14.sp),
            start = length,
            end = length + termsAndConditionsText.length
        )
        addStringAnnotation(
            tag = "TERMS",
            annotation = "terms",
            start = length,
            end = length + termsAndConditionsText.length
        )
        append(termsAndConditionsText)
    }

    Text(
        text = annotatedString,
        fontSize = 14.sp,
        style = TextStyle(textDecoration = TextDecoration.Underline),
        modifier = Modifier.clickable {
            // Extract the clicked annotation
            val annotation = annotatedString.getStringAnnotations(0, annotatedString.length)
                .firstOrNull()

            when (annotation?.tag) {
                "PRIVACY_POLICY" -> onPrivacyPolicyClick()
                "TERMS" -> onTermsClick()
            }
        }
    )
}


@Composable
fun GradientButton(value: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent), // No default color
        shape = RoundedCornerShape(12.dp) // Optional rounded corners
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(Secondary, Primary) // Apply gradient with your defined colors
                    ),
                    shape = RoundedCornerShape(12.dp) // Shape of the box
                ),
            contentAlignment = Alignment.Center // Center text inside Box
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White // Text color
            )
        }
    }
}

@Composable
fun DividerTextComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier
                .weight(1f),
            thickness = 1.dp,
            color = GrayColor
        )

        Spacer(modifier = Modifier.width(8.dp)) // Space between divider and text

        Text(
            text = "OR",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = GrayColor
        )

        Spacer(modifier = Modifier.width(8.dp)) // Space between text and divider

        HorizontalDivider(
            modifier = Modifier
                .weight(1f),
            thickness = 1.dp,
            color = GrayColor
        )
    }
}

@Composable
fun ClickableLoginTextComponent(
    normalText: String,
    clickableText: String,
    onTextSelected: (String) -> Unit
) {
    val annotatedString = buildAnnotatedString {
        append(normalText)

        val start = length
        append(clickableText)
        addStringAnnotation(
            tag = "CLICKABLE",
            annotation = clickableText,
            start = start,
            end = length
        )
        addStyle(
            style = SpanStyle(color = Primary, fontWeight = FontWeight.Bold),
            start = start,
            end = length
        )
    }

    Text(
        text = annotatedString,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                val annotation = annotatedString.getStringAnnotations(
                    tag = "CLICKABLE",
                    start = 0,
                    end = annotatedString.length
                ).firstOrNull()

                annotation?.let {
                    onTextSelected(it.item)
                }
            },
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        )
    )
}



@Composable
fun UnderLinedTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            color = colorResource(id = R.color.colorGray),
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )
    )
}


