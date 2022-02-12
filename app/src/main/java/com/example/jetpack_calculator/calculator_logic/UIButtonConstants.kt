package com.example.jetpack_calculator.calculator_logic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


const val AC = "AC"
const val Backspace = "⌫"
const val Point = "."
const val Divide = "÷"
const val PlusMinus = "+/-"

const val Seven = "7"
const val Eight = "8"
const val Nine = "9"
const val Multiply = "x"


const val Four = "4"
const val Five = "5"
const val Six = "6"
const val Minus = "-"


const val One = "1"
const val Two = "2"
const val Three = "3"
const val Plus = "+"

const val Zero = "0"
const val Solve = "="

val firstRow by lazy { listOf(AC, PlusMinus, Backspace, Divide) }
val secondRow by lazy { listOf(Seven, Eight, Nine, Multiply) }
val thirdRow by lazy { listOf(Four, Five, Six, Minus) }
val forthRow by lazy { listOf(One, Two, Three, Plus) }
val fifthRow by lazy { listOf(Zero, Point, Solve) }
val ButtonModifier = Modifier.fillMaxWidth()
val  ButtonArrangement= Arrangement.spacedBy(15.dp)
