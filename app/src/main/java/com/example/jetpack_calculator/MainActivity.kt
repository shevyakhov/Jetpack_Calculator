package com.example.jetpack_calculator

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpack_calculator.ui.Buttons
import com.example.jetpack_calculator.ui.GradientScreen
import com.example.jetpack_calculator.ui.TopBar
import com.example.jetpack_calculator.ui.theme.Jetpack_CalculatorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}


@Composable
fun MyApp() {
    Jetpack_CalculatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.onSurface
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TopBar(appName = "Calculator")
                GradientScreen(text = "132")
                Buttons()
            }
        }
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MyAppPreview() {

    MyApp()
}