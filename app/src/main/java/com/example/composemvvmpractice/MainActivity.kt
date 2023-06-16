package com.example.composemvvmpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import androidx.compose.material3.Button
import androidx.compose.material3.Text


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        setContent {

            MyApp(viewModel)
        }
    }
}

@Composable
fun MyApp(viewModel: MyViewModel) {

    val number: Int = viewModel.currentNumber.observeAsState(0).value

// Starts observing this LiveData and represents its values via State.

    Column() {
        Text(text = "current number: $number")
        Button(onClick = { viewModel.increase() }) {
            Text(text = "Add 1")
        }

        Button(onClick = { viewModel.decrease() }) {
            Text(text = "Minus 1")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val viewModel = MyViewModel()
    MyApp(viewModel)
}
