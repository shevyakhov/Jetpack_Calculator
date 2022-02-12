package com.example.jetpack_calculator.view_model

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.mariuszgromada.math.mxparser.Expression

class AppViewModel : ViewModel() {
    var string = mutableStateOf<String>("")

    fun update(input: String): Unit {
        when (input) {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-" -> passString(input)
            "=" -> calculate()
            "x" -> passString("*")
            "÷" -> passString("/")

            "," -> passString(".")
            "+/-" -> checkForMinus()
            "AC" -> clearString()
            "⌫" -> pushBack()

        }

    }

    private fun passString(str: String) {
        Log.e("string = ", str)
        string.value = string.value + str
        Log.e("string = ", string.value)
    }

    private fun calculate() {
        try {

            Log.e("string = ", string.value)
            val result = Expression(string.value).calculate()
            val e = Expression("2+3").calculate()
            Log.e("result", result.toString())
            Log.e("e", e.toString())
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

    private fun clearString() {
        string.value = ""
    }

    private fun checkForMinus() {
        if (string.value.isNotBlank()) {
            if (string.value.startsWith("-")) {
                string.value = string.value.drop(1)
                Log.e("1", "1")
            } else {
                Log.e("2", "2")
                string.value = "-" + string.value
            }
        } else {
            Log.e("no", "no")
            string.value = "-"
        }
    }

    private fun pushBack() {
        string.value = string.value.dropLast(1)
    }

}