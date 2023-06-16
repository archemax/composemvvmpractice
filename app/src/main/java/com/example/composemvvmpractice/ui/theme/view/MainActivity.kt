package com.example.composemvvmpractice.ui.theme.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.composemvvmpractice.ui.theme.viewmodel.MyViewModel
import kotlinx.coroutines.flow.StateFlow
import androidx.compose.runtime.livedata.observeAsState
import kotlinx.coroutines.flow.observeOn

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

    val num : Int = viewModel.currentNumber.collectAsState().value

    Log.d ("my_num_MA", "$num")

// Starts observing this LiveData and represents its values via State.
    Column() {
        Text(text = "current number: $num")
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
