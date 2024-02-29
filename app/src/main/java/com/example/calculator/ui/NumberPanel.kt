package com.example.calculator.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


private val operationsColumn = listOf("Delete", "÷", "x", "-", "+")

private val numberColumns = listOf(
    listOf("7", "4", "1"),
    listOf("8", "5", "2"),
    listOf("9", "6", "3")
)

@Composable
fun NumberPanel() {
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        numberColumns.forEach { numberColumn ->
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                numberColumn.forEach { text ->
                    MainContentButton(text)
                }
            }
        }
        Divider(
            modifier = Modifier.width(1.dp).fillMaxHeight(),
            color = Color(0xFFd3d3d3)
        )
        Column(modifier = Modifier.weight(1.3f)) {
            operationsColumn.forEach { operation ->
                OperationItem(text = operation)
            }
        }
        Spacer(modifier = Modifier.width(30.dp))
    }
}

@Composable
fun MainContentButton(text: String) {
    Text(text = text, textAlign = TextAlign.Center)
}

@Composable
fun OperationItem(text: String) {
    Text(text = text, textAlign = TextAlign.Center)

}