package com.example.composemvvmpractice.ui.theme.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.observeOn

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreen()
        }
    }
}

@Composable
fun MyScreen() {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        MyApp()
    }
}

@Composable
fun MyApp() {
    val viewModel: MyViewModel = viewModel()

    val num: Int = viewModel.currentNumber.collectAsState().value

// Starts observing this LiveData and represents its values via State.
    Text(
        text = "$num",
        fontSize = 100.sp,
        modifier = Modifier
            .wrapContentSize()

    )

    Button(
        onClick = { viewModel.increase() },
        modifier = Modifier
            .wrapContentSize(align = Alignment.CenterEnd)
            .padding(20.dp)
            .height(60.dp)
            .width(130.dp)
    ) {
        Text(
            text = "Add 1",
            fontSize = 20.sp
        )
    }

    Button(
        onClick = { viewModel.decrease() },
        modifier = Modifier
            .wrapContentSize(align = Alignment.CenterStart)
            .padding(20.dp)
            .height(60.dp)
            .width(130.dp)
    ) {
        Text(
            text = "Minus 1",
            fontSize = 20.sp
        )
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyScreen()


}
