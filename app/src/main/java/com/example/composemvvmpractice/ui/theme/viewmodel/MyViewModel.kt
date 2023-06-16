package com.example.composemvvmpractice.ui.theme.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first

class MyViewModel : ViewModel() {


    private val _currentNumber = MutableStateFlow<Int>(0)
    val currentNumber: StateFlow<Int> get() = _currentNumber

    fun increase() {
     _currentNumber.value += 1
    }

    fun decrease() {
        _currentNumber.value -= 1
    }

}
