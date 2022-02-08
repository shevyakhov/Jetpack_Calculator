package com.example.jetpack_calculator

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_calculator.ui.theme.Jetpack_CalculatorTheme
import com.example.jetpack_calculator.ui.theme.gradOne
import com.example.jetpack_calculator.ui.theme.gradTwo


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
            color = MaterialTheme.colors.secondary
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TopBar(appName = "Calculator")
                GradientScreen(text = "123231")
            }
        }
    }
}

@Composable
fun Buttons() {
    Column() {
        Text(text = "asdasd")
        Text(text = "asdasd")
        Text(text = "asdasd")
        Text(text = "asdasd")
    }


}

@Composable
fun TopBar(appName: String) {
    TopAppBar(
        title = {
            Text(text = appName, style = MaterialTheme.typography.body1)
        },
        backgroundColor = MaterialTheme.colors.secondary
    )
}

@Composable
fun GradientScreen(
    text: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 15.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            gradOne,
                            gradTwo
                        )
                    ), shape = RoundedCornerShape(10.dp)
                )
                .height(100.dp)
                .width(350.dp),
            contentAlignment = Alignment.CenterEnd,
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.body2,
                fontSize = 50.sp,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
            Text(
                text = "888888888888",
                style = MaterialTheme.typography.body2,
                fontSize = 50.sp,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
        }
    }

}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MyAppPreview() {

    MyApp()
}