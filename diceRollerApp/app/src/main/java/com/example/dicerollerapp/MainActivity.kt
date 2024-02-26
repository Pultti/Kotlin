package com.example.dicerollerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dicerollerapp.ui.theme.DiceRollerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
        .padding(16.dp) // CSS-like property for spacing around the content
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result1 by remember { mutableStateOf(1) } // State for the first dice
    var result2 by remember { mutableStateOf(1) } // State for the second dice

    val imageResource1 = when(result1) { // Determine the image for the first dice
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    val imageResource2 = when(result2) { // Determine the image for the second dice
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    // CSS-like styling for the column layout
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(imageResource1),
            contentDescription = result1.toString(),
            modifier = Modifier.size(150.dp) // CSS-like property for setting size
        )
        Spacer(modifier = Modifier.height(24.dp)) // Space between the two dice images
        Image(
            painter = painterResource(imageResource2),
            contentDescription = result2.toString(),
            modifier = Modifier.size(150.dp) // CSS-like property for setting size
        )

        Spacer(modifier = Modifier.height(24.dp)) // CSS-like margin-top

        // CSS-like properties for the button
        Button(
            onClick = {
                result1 = (1..6).random() // Roll the first dice
                result2 = (1..6).random() // Roll the second dice
            },
            modifier = Modifier.padding(8.dp) // CSS-like padding inside the button
        ) {
            Text(
                text = "Roll",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White // CSS-like text color
            )
        }
    }
}