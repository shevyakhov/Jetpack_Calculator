package com.example.jetpack_calculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_calculator.R
import com.example.jetpack_calculator.calculator_logic.*
import com.example.jetpack_calculator.ui.theme.*

val ButtonModifier = Modifier.fillMaxWidth()
val ButtonArrangement = Arrangement.spacedBy(15.dp)

@Composable
fun TopBar(appName: String, modifier: Modifier) {

    Text(
        text = appName,
        modifier = modifier,
        style = MaterialTheme.typography.body1,
        textAlign = TextAlign.Left,
        color = Color.Black
    )

}

@Composable
fun GradientScreen(
    state: MutableState<String>
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
                            GradOne,
                            GradTwo
                        )
                    ), shape = RoundedCornerShape(10.dp)
                )
                .height(100.dp)
                .width(350.dp),
            contentAlignment = Alignment.CenterEnd,
        ) {
            Text(
                text = state.value,
                style = MaterialTheme.typography.body2,
                fontSize = 50.sp,
                maxLines = 1,
                modifier = Modifier.padding(horizontal = 15.dp),
                overflow = TextOverflow.Ellipsis,
                softWrap = false,
                /*
                * ellipsis start is not created yet
                * */
                textAlign = TextAlign.Start,
                letterSpacing = 2.sp
            )
            Text(
                text = stringResource(id = R.string.eightsString),
                style = MaterialTheme.typography.body2,
                fontSize = 50.sp,
                maxLines = 1, textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .alpha(alpha = checkForEmptyString(state.value)),
                letterSpacing = 2.sp
            )
        }
    }
}

fun checkForEmptyString(string: String): Float {
    return if (string.isNotBlank()) {
        0.015f
    } else
        0.05f
}


@Composable
fun Buttons(lists: List<List<UIButtonConstants>>, onButtonClick: (UIButtonConstants) -> Unit) {
    Column(
        modifier = Modifier
            .padding(vertical = 30.dp, horizontal = 15.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {

        for (list in lists) {
            Row(
                ButtonModifier, ButtonArrangement
            ) {
                for (name in list.indices) {
                    val color = checkColor(list, name)
                    Button(name =list[name], color = color, onButtonClick = onButtonClick)
                }
            }
        }
    }
}


@Composable
fun Button(name: UIButtonConstants, color: Color, onButtonClick: (UIButtonConstants) -> Unit) {
    Button(
        onClick = { onButtonClick(name) },
        modifier = Modifier
            .clip(shape = RoundedCornerShape(15.dp))
            .width(checkWidth(name))
            .height(80.dp)
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(25.dp)

            ),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = color
        )
    ) {
        Text(
            text = name.UISymbol,
            color = checkColor(color),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Left
        )
    }
}

private fun checkWidth(name: UIButtonConstants): Dp {
    return if (name == UIButtonConstants.Zero) {
        175.dp
    } else
        80.dp
}

private fun checkColor(color: Color): Color {
    return if (color == MainBlue) {
        MainGrey
    } else
        MainBlue
}

private fun checkColor(list: List<UIButtonConstants>, index: Int): Color {
    return if (index == list.size - 1) {
        MainBlue
    } else
        MainGrey
}
