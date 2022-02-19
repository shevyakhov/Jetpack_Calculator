package com.example.jetpack_calculator.calculator_logic

import com.example.jetpack_calculator.R


enum class UIButtonConstants(val UISymbol: Int, val parserSymbol: Int) {
    AC(R.string.AC, R.string.AC),
    Backspace(R.string.Backspace, R.string.Backspace),
    Point(R.string.Point, R.string.Point),
    Divide(R.string.Divide, R.string.DivideTrue),
    PlusMinus(R.string.PlusMinus, R.string.PlusMinusTrue),
    Seven(R.string.Seven, R.string.Seven),
    Eight(R.string.Eight, R.string.Eight),
    Nine(R.string.Nine, R.string.Nine),
    Multiply(R.string.Multiply, R.string.MultiplyTrue),
    Four(R.string.Four, R.string.Four),
    Five(R.string.Five, R.string.Five),
    Six(R.string.Six, R.string.Six),
    Minus(R.string.Minus, R.string.Minus),
    One(R.string.One, R.string.One),
    Two(R.string.Two, R.string.Two),
    Three(R.string.Three, R.string.Three),
    Plus(R.string.Plus, R.string.Plus),
    Zero(R.string.Zero, R.string.Zero),
    Solve(R.string.Solve, R.string.Solve),
}

val firstRow by lazy {
    listOf(
        UIButtonConstants.AC,
        UIButtonConstants.PlusMinus,
        UIButtonConstants.Backspace,
        UIButtonConstants.Divide
    )
}
val secondRow by lazy {
    listOf(
        UIButtonConstants.Seven,
        UIButtonConstants.Eight,
        UIButtonConstants.Nine,
        UIButtonConstants.Multiply
    )
}
val thirdRow by lazy {
    listOf(
        UIButtonConstants.Four,
        UIButtonConstants.Five,
        UIButtonConstants.Six,
        UIButtonConstants.Minus
    )
}
val forthRow by lazy {
    listOf(
        UIButtonConstants.One,
        UIButtonConstants.Two,
        UIButtonConstants.Three,
        UIButtonConstants.Plus
    )
}
val fifthRow by lazy {
    listOf(
        UIButtonConstants.Zero,
        UIButtonConstants.Point,
        UIButtonConstants.Solve
    )
}

