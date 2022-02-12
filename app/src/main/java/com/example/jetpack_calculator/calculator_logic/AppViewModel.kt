package com.example.jetpack_calculator.calculator_logic

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.mariuszgromada.math.mxparser.Expression

class AppViewModel : ViewModel() {
    var string = mutableStateOf("")

    fun update(input: String) {

        when (input) {

            Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Plus, Minus -> {
                passString(input)
            }
            Solve -> calculate()
            Multiply -> passString("*")
            Divide -> passString("/")
            Point -> passString(".")
            PlusMinus -> checkForMinus()
            AC -> clearString()
            Backspace -> pushBack()

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
            if (string.value.startsWith(Minus)) {
                string.value = string.value.drop(1)

            } else {
                string.value = Minus + string.value
            }
        } else {

            string.value = Minus
        }
    }

    private fun pushBack() {
        string.value = string.value.dropLast(1)
    }

}