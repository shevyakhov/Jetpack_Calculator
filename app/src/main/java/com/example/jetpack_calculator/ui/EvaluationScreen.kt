package com.example.jetpack_calculator.ui

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
fun TopBar(appName: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        color = MaterialTheme.colors.secondary
    ) {
        Text(
            text = appName,
            modifier = Modifier.padding(15.dp),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Left
        )
    }
}

@Composable
fun GradientScreen(
    avm: AppViewModel
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
                text = avm.string.value,
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
                    .alpha(alpha = checkForEmptyString(avm.string.value)),
                letterSpacing = 2.sp
            )
        }
    }
}

fun checkForEmptyString(string: String): Float {
    return if (string.isNotBlank()) {
        0.015f
    }
    else
        0.05f
}


@Composable
fun Buttons(avm: AppViewModel) {
    val onButtonClick: (UIButtonConstants) -> Unit = { name: UIButtonConstants -> avm.update(name) }
    Column(
        modifier = Modifier
            .padding(vertical = 30.dp, horizontal = 15.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {

        Row(
            ButtonModifier, ButtonArrangement
        ) {

            Button(names = firstRow, onButtonClick = onButtonClick)
        }
        Row(
            ButtonModifier, ButtonArrangement
        ) {
            Button(names = secondRow, onButtonClick = onButtonClick)
        }
        Row(
            ButtonModifier, ButtonArrangement
        ) {
            Button(names = thirdRow, onButtonClick = onButtonClick)
        }
        Row(
            ButtonModifier, ButtonArrangement
        ) {
            Button(names = forthRow, onButtonClick = onButtonClick)
        }
        Row(
            ButtonModifier, ButtonArrangement
        ) {
            Button(names = fifthRow, onButtonClick = onButtonClick)
        }
    }

}

@Composable
fun Button(names: List<UIButtonConstants>, onButtonClick: (UIButtonConstants) -> Unit) {
    for (name in names.indices) {
        val color = checkColor(names, name)
        Button(
            onClick = { onButtonClick(names[name]) },
            modifier = Modifier
                .clip(shape = RoundedCornerShape(15.dp))
                .width(checkWidth(names[name]))
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
                text = names[name].UISymbol,
                color = checkColor(color),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Left
            )
        }
    }
}

fun checkWidth(name: UIButtonConstants): Dp {
    return if (name == UIButtonConstants.Zero) {
        175.dp
    } else
        80.dp
}

fun checkColor(color: Color): Color {
    return if (color == MainBlue) {
        MainGrey
    } else
        MainBlue
}

fun checkColor(list: List<UIButtonConstants>, index: Int): Color {
    return if (index == list.size - 1) {
        MainBlue
    } else
        MainGrey
}
