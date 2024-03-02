package com.example.calculator.ui

enum class OperatorEnum(private val operator : String) {
    DIVIDED("/"),
    MULTIPLY("x"),
    MINUS("-"),
    PLUS("+");

    override fun toString() = operator

}