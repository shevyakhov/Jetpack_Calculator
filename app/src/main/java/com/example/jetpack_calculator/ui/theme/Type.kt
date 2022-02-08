package com.example.jetpack_calculator.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jetpack_calculator.R

val yanus = FontFamily(
    Font(R.font.yanus)
)
val digit = FontFamily(
    Font(R.font.digit)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = yanus,
        fontWeight = FontWeight.W700,
        fontSize = 29.sp
    ),
    body2 = TextStyle(
        fontFamily = digit,
        fontWeight = FontWeight.W500,
        fontSize = 29.sp,
        color = Color.Black
    )
)

/* Other default text styles to override
button = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp
),
caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)
*/

