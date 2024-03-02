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


private val operationsColumn = listOf("Delete", "÷", "x", "-", "+")

private val numberColumns = listOf(
    listOf("7", "4", "1"),
    listOf("8", "5", "2"),
    listOf("9", "6", "3")
)

@Composable
fun NumberPanel(
    modifier: Modifier
) {

    val buttonSpacing = 8.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
                .background(Color.DarkGray)
        ) {
            Text(
                text = "123123123",
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
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                NumberButton(
                    number = "AC",
                    modifier = Modifier
                        .aspectRatio(2F)
                        .weight(2f),
                    onClick = {
                        (Unit)
                    },
                    color =  Color.LightGray
                )

                NumberButton(
                    number = "Del",
                    modifier = Modifier
                        .aspectRatio(1F)
                        .weight(1f),
                    onClick = {
                        (Unit)
                    },
                    color =  Color.LightGray
                )

                NumberButton(
                    number = "/",
                    modifier = Modifier
                        .aspectRatio(1F)
                        .weight(1f),
                    onClick = {
                        (Unit)
                    },
                    color =  Color.LightGray
                )
            }
        }
    }

//    Row(
//        modifier = Modifier
//            .fillMaxSize(),
//        horizontalArrangement = Arrangement.SpaceEvenly
//    ) {
//        numberColumns.forEach { numberColumn ->
//            Column(
//                modifier = Modifier.weight(1f),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                numberColumn.forEach { text ->
//                    MainContentButton(text)
//                }
//            }
//        }
//        Divider(
//            modifier = Modifier.width(1.dp).fillMaxHeight(),
//            color = Color(0xFFd3d3d3)
//        )
//        Column(modifier = Modifier.weight(1.3f)) {
//            operationsColumn.forEach { operation ->
//                OperationItem(text = operation)
//            }
//        }
//        Spacer(modifier = Modifier.width(30.dp))
//    }
}

@Composable
fun MainContentButton(text: String) {
    Text(text = text, textAlign = TextAlign.Center)
}

@Composable
fun OperationItem(text: String) {
    Text(text = text, textAlign = TextAlign.Center)

}

@Composable
fun NumberButton(
    number : String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    color : Color = Color.White
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
    ){
        Text(
            text = number,
            color = Color.White,
            fontSize = 40.sp
        )
    }

}