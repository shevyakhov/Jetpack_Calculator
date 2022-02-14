package com.example.jetpack_calculator.calculator_logic


enum class UIButtonConstants(val UISymbol: String, val parserSymbol: String) {
    AC("AC", ""),
    Backspace("⌫", " "),
    Point(".", "."),
    Divide("÷", "/"),
    PlusMinus("+/-", "+/-"),
    Seven("7", "7"),
    Eight("8", "8"),
    Nine("9", "9"),
    Multiply("x", "*"),
    Four("4", "4"),
    Five("5", "5"),
    Six("6", "6"),
    Minus("-", "-"),
    One("1", "1"),
    Two("2", "2"),
    Three("3", "3"),
    Plus("+", "+"),
    Zero("0", "0"),
    Solve("=", "="),
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

