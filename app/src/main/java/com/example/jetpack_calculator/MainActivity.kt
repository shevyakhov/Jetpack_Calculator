package com.example.jetpack_calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack_calculator.calculator_logic.*
import com.example.jetpack_calculator.ui.Button
import com.example.jetpack_calculator.ui.Buttons
import com.example.jetpack_calculator.ui.GradientScreen
import com.example.jetpack_calculator.ui.TopBar
import com.example.jetpack_calculator.ui.theme.Jetpack_CalculatorTheme
import com.example.jetpack_calculator.ui.theme.MainGrey

class MainActivity : ComponentActivity() {
    private lateinit var vm: AppViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }

    }

    @Composable
    fun MyApp() {
        vm = ViewModelProvider(this)[AppViewModel::class.java]
        val listOfButtons = listOf(firstRow, secondRow, thirdRow, forthRow, fifthRow)
        val onButtonClick: (UIButtonConstants) -> Unit =
            { name: UIButtonConstants -> vm.update(name) }
        val string = vm.getValueString()
        Jetpack_CalculatorTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.onSurface
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TopBar(
                        getString(R.string.app_name),
                        Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                    )
                    GradientScreen(string)

                    Buttons(listOfButtons, onButtonClick)

                }
            }
        }
    }

    @Preview
    @Composable
    fun AppPreview() {
        Jetpack_CalculatorTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.onSurface
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TopBar(
                        appName = stringResource(id = R.string.app_name),
                        Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                    )
                    val string = mutableStateOf("88888")
                    GradientScreen(string)
                    val list = listOf(firstRow, secondRow, thirdRow, forthRow, fifthRow)
                    Buttons(list, onButtonClick = { Log.e("DONE", "Click") })

                }
            }
        }
    }

    @Preview
    @Composable
    fun TopBarPreview() {

        TopBar(
            appName = stringResource(id = R.string.app_name),
            Modifier
                .fillMaxWidth()
                .padding(15.dp)
        )
    }

    @Preview
    @Composable
    fun ButtonsPreview() {
        val list = listOf(firstRow, secondRow, thirdRow, forthRow, fifthRow)
        Buttons(list, onButtonClick = { Log.e("DONE", "Click") })
    }

    @Preview
    @Composable
    fun ButtonPreview() {
        Button(
            name = UIButtonConstants.AC,
            color = MainGrey,
            onButtonClick = { Log.e("DONE", "Click") })
    }

    @SuppressLint("UnrememberedMutableState")
    @Preview
    @Composable
    fun GradientScreenPreview() {
        val string = mutableStateOf("88888")
        GradientScreen(string)
    }

}




