package com.example.calculator.ui

sealed class CalculatorAction {
    data class Number(val number: Int) : CalculatorAction()
    object Clear : CalculatorAction()
    object Delete: CalculatorAction()
    data class Operation(val operation: CalculatorOperation )
    object Calculate: CalculatorAction()
    object Decimal: CalculatorAction()
}
