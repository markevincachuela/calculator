package com.example.calculator.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


private val topColumns = listOf("AC", "Del", "/")
private val bottomColumn = listOf("0", ".", "=")

private val numberColumns = listOf(
    listOf("7", "4", "1","0"),
    listOf("8", "5", "2","."),
    listOf("9", "6", "3",""),
    listOf("x", "+", "-","=")
)

@Composable
fun NumberPanel(
    modifier: Modifier
) {

    val buttonSpacing = 8.dp
    val calculatorViewModel = viewModel<CalculatorViewModel>()
    val state = calculatorViewModel.state
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Column(
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 40.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )

            Row(
                modifier = Modifier
                    .padding(10.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                topColumns.forEach {
                    when (it) {
                        "AC" -> {
                            NumberButton(
                                number = it,
                                modifier = Modifier
                                    .aspectRatio(2F)
                                    .weight(2f),
                                onClick = {
                                    calculatorViewModel.onAction(CalculatorAction.Clear)
                                },
                                color = Color.LightGray
                            )
                        }

                        CalculatorViewModel.DIVIDED -> {
                            NumberButton(
                                number = it,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    calculatorViewModel.onAction(
                                        CalculatorAction.Operation(CalculatorOperation.Divide)
                                    )
                                },
                                color = Color.Magenta
                            )
                        }

                        else -> {
                            NumberButton(
                                number = it,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f),
                                onClick = {
                                    calculatorViewModel.onAction(
                                        CalculatorAction.Delete
                                    )
                                },
                                color = Color.LightGray
                            )
                        }
                    }

                }
            }
            Row {
                numberColumns.forEach { numberColumn ->
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(buttonSpacing)
                    ) {
                        numberColumn.forEach { text ->
                            when (text) {
                                CalculatorViewModel.SUBTRACT -> {
                                    NumberButton(
                                        number = text,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            calculatorViewModel.onAction(
                                                CalculatorAction.Operation(CalculatorOperation.Subtract)
                                            )
                                        },
                                        color = Color.Magenta
                                    )
                                }
                                CalculatorViewModel.MULTIPLY -> {
                                    NumberButton(
                                        number = text,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            calculatorViewModel.onAction(
                                                CalculatorAction.Operation(CalculatorOperation.Multiply)
                                            )
                                        },
                                        color = Color.Magenta
                                    )
                                }

                                CalculatorViewModel.ADD -> {
                                    NumberButton(
                                        number = text,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            calculatorViewModel.onAction(
                                                CalculatorAction.Operation(CalculatorOperation.Add)
                                            )
                                        },
                                        color = Color.Magenta
                                    )
                                }
                                CalculatorViewModel.RESULT -> {
                                    NumberButton(
                                        number = text,
                                        modifier = modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            calculatorViewModel.onAction(CalculatorAction.Calculate)
                                        },
                                        color = Color.Magenta
                                    )
                                }
                                CalculatorViewModel.DECIMAL -> {
                                    NumberButton(
                                        number = text,
                                        modifier = modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            calculatorViewModel.onAction(CalculatorAction.Decimal)
                                        },
                                        color = Color.LightGray
                                    )
                                }
                                "0" -> {
                                    NumberButton(
                                        number = text,
                                        modifier = modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            calculatorViewModel.onAction(
                                                CalculatorAction.Number(
                                                    number = text.toInt()
                                                )
                                            )
                                        },
                                        color = Color.LightGray
                                    )
                                }
                                "" -> {
                                    NumberButton(number = "",
                                        modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f),
                                        onClick = {  },
                                        color = Color.LightGray)
                                }
                                else -> {
                                    NumberButton(
                                        number = text,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f),
                                        onClick = {
                                            calculatorViewModel.onAction(
                                                CalculatorAction.Number(
                                                    text.toInt()
                                                )
                                            )
                                        },
                                        color = Color.LightGray
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun NumberButton(
    number: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    color: Color = Color.White
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(color)
            .clickable {
                onClick()
            }
            .then(modifier)
    ) {
        Text(
            text = number,
            color = Color.White,
            fontSize = 40.sp
        )
    }

}