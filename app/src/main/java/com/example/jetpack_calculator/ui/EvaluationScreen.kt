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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_calculator.calculator_logic.*
import com.example.jetpack_calculator.ui.theme.*

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
                letterSpacing = 3.sp
            )
            Text(
                text = "888888888888",
                style = MaterialTheme.typography.body2,
                fontSize = 50.sp,
                maxLines = 1,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .alpha(0.05f),
                letterSpacing = 3.sp
            )
        }
    }
}


@Composable
fun Buttons(avm: AppViewModel) {
    /* Could make an ENUM class for buttons but why bother :)*/
    Column(
        modifier = Modifier
            .padding(vertical = 30.dp, horizontal = 15.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {

        ButtonsRow(list = firstRow, avm = avm)
        ButtonsRow(list = secondRow, avm = avm)
        ButtonsRow(list = thirdRow, avm = avm)
        ButtonsRow(list = forthRow, avm = avm)
        ButtonsRow(list = fifthRow, avm = avm)

    }

}

@Composable
fun Button(names: List<String>, avm: AppViewModel) {
    for (name in names.indices) {
        val color = checkColor(names, name)
        Button(
            onClick = { avm.update(names[name]) },
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
                text = names[name],
                color = checkColor(color),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Left
            )
        }
    }
}

@Composable
fun ButtonsRow(list: List<String>, avm: AppViewModel) {
    Row(
        ButtonModifier, ButtonArrangement
    ) {
        Button(names = list, avm)
    }
}

fun checkWidth(name: String): Dp {
    return if (name == "0") {
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

fun checkColor(list: List<String>, index: Int): Color {
    return if (index == list.size - 1) {
        MainBlue
    } else
        MainGrey
}