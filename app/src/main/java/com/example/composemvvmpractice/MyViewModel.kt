package com.example.composemvvmpractice

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    private var _currentNumber = MutableLiveData<Int>(0)
    val currentNumber: LiveData<Int>  = _currentNumber

    // set methods
    fun increase (){
        _currentNumber.value = _currentNumber.value?.plus(1)
    }

    fun decrease (){
        if (_currentNumber.value == 0) return
        else{
            _currentNumber.value = _currentNumber.value?.minus(1)
        }

    }
}