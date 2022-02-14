package com.example.jetpack_calculator.calculator_logic

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.mariuszgromada.math.mxparser.Expression

class AppViewModel : ViewModel() {
    var string = mutableStateOf("")

    fun update(input: UIButtonConstants) {

        when (input) {

            UIButtonConstants.Zero,
            UIButtonConstants.One,
            UIButtonConstants.Two,
            UIButtonConstants.Three,
            UIButtonConstants.Four,
            UIButtonConstants.Five,
            UIButtonConstants.Six,
            UIButtonConstants.Seven,
            UIButtonConstants.Eight,
            UIButtonConstants.Nine,
            UIButtonConstants.Plus,
            UIButtonConstants.Multiply,
            UIButtonConstants.Divide,
            UIButtonConstants.Point,
            UIButtonConstants.Minus -> {
                passString(input.parserSymbol)
            }
            UIButtonConstants.Solve -> calculate()
            UIButtonConstants.PlusMinus -> checkForMinus()
            UIButtonConstants.AC -> clearString()
            UIButtonConstants.Backspace -> pushBack()

        }

    }

    private fun passString(str: String) {
        string.value = string.value + str
    }

    private fun calculate() {
        if (string.value.isNotBlank()) {
            try {


                val result = Expression(string.value).calculate()

                val noDot = result.toLong()
                val formatted = String.format("%.3f", result).replace(',', '.')
                if (result.equals(noDot.toDouble())) {
                    string.value = noDot.toString()
                } else
                    string.value = formatted
            } catch (e: Exception) {
                Log.d("Ошибка", " ${e.message}")
            }
        }
    }

    private fun clearString() {
        string.value = ""
    }

    private fun checkForMinus() {
        if (string.value.isNotBlank()) {
            if (string.value.startsWith(UIButtonConstants.Minus.parserSymbol)) {
                string.value = string.value.drop(1)

            } else {
                string.value = UIButtonConstants.Minus.parserSymbol + string.value
            }
        } else {

            string.value = UIButtonConstants.Minus.parserSymbol
        }
    }

    private fun pushBack() {
        string.value = string.value.dropLast(1)
    }

}