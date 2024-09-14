package com.example.directiongame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.directiongame.ui.theme.DirectionGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DirectionGameTheme {
                Directiongame()
            }
        }
    }
}

@Composable
fun Directiongame() {
    val treasuresFound = remember { mutableStateOf(0) }
    val direction = remember { mutableStateOf("North") }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                direction.value = "East"
                if (Random.nextBoolean()) {
                    treasuresFound.value++
                }
            }) {
                Text("East")
            }

            Button(onClick = {
                direction.value = "West"
                if (Random.nextBoolean()) {
                    treasuresFound.value++
                }
            }) {
                Text("West")
            }

            Button(onClick = {
                direction.value = "South"
                if (Random.nextBoolean()) {
                    treasuresFound.value++
                }
            }) {
                Text("South")
            }

            Button(onClick = {
                direction.value = "North "
                if (Random.nextBoolean()) {
                    treasuresFound.value++
                }
            }) {
                Text("North")
            }

            Text(text = "You are facing ${direction.value}")
            Text(text = "You found ${treasuresFound.value} treasures")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DirectionGamePreview() {
    DirectionGameTheme {
        Directiongame()
    }
}