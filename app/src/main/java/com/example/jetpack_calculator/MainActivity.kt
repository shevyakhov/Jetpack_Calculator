package com.example.jetpack_calculator

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_calculator.ui.theme.*


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
                .padding(vertical = 30.dp)
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
                maxLines = 1,
                modifier = Modifier.padding(horizontal = 15.dp),
                overflow = TextOverflow.Ellipsis,
                softWrap = false,
                /*
                * ellipsis start needed
                * */
                textAlign = TextAlign.Start,
                letterSpacing = 4.sp
            )
            Text(
                text = "888888888888",
                style = MaterialTheme.typography.body2,
                fontSize = 50.sp,
                maxLines = 1,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .alpha(0.05f),
                letterSpacing = 4.sp
            )
        }
    }

}

@Composable
fun Buttons() {

    Column(
        modifier = Modifier
            .padding(vertical = 30.dp, horizontal = 15.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            val list = listOf("AC", "+/-", "%", "÷")
            Button(names = list)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            val list = listOf("7", "8", "9", "x")
            Button(names = list)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            val list = listOf("4", "5", "6", "-")
            Button(names = list)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            val list = listOf("1", "2", "3", "+")
            Button(names = list)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            val list = listOf("0", ",", "=")
            Button(names = list)
        }

    }

}

@Composable
fun Button(names: List<String>) {
    for (name in names.indices) {
        val color = checkColor(names, name)
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .clip(shape = RoundedCornerShape(15.dp))
                .width(checkWidth(names[name]))
                .height(80.dp).shadow(
                    elevation = 2.dp,
                    shape = RoundedCornerShape(25.dp)

                ),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = color
            )
        ) {
            Text(
                text = names[name],
                color = checkColor(color),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Left
            )
        }
    }
}

fun checkWidth(name: String): Dp {
    return if (name == "0") {
        175.dp
    } else
        80.dp
}

fun checkColor(color: Color): Color {
    return if (color == mainBlue) {
        mainGrey
    } else
        mainBlue
}

fun checkColor(list: List<String>, index: Int): Color {
    return if (index == list.size - 1) {
        mainBlue
    } else
        mainGrey
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MyAppPreview() {

    MyApp()
}