package com.example.calculator.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    var state by mutableStateOf(CalculatorState())

//
//    fun onAction(action: CalculatorAction) {
//        when(action) {
//            is CalculatorAction.Clear ->
//            is CalculatorAction.Delete -> TODO()
//            is CalculatorAction.Number -> TODO()
//            is CalculatorAction.Calculate -> TODO()
//            is CalculatorAction.Decimal -> TODO()
//            is CalculatorAction.Delete -> TODO()
//        }
//    }
}