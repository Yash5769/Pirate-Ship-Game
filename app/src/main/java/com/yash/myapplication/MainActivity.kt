package com.yash.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.yash.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    captaingame()
                }
            }
        }
    }

    @Composable
    fun captaingame() {
        val treasureFound = remember { mutableStateOf(0) }
        val currentDirection = remember { mutableStateOf("") }
        val context = LocalContext.current
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Try Your Luck And Find the Treasures")
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Text(text = "Treasure Found:${treasureFound.value}")
                Spacer(modifier = Modifier.width(32.dp))
                Text(text = "Current Direction:${currentDirection.value}")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                currentDirection.value = "East"
                when {
                    Random.nextBoolean() -> {
                        treasureFound.value += 1
                        Toast.makeText(context, "Treasure Found", Toast.LENGTH_SHORT).show()
                    }

                    else -> {
                        Toast.makeText(context, "Treasure Not Found", Toast.LENGTH_SHORT).show()
                    }
                }
            })
            {
                Text(text = "Sail East")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                currentDirection.value = "West"
                when {
                    Random.nextBoolean() -> {
                        treasureFound.value += 1
                        Toast.makeText(context, "Treasure Found", Toast.LENGTH_SHORT).show()
                    }

                    else -> {
                        Toast.makeText(context, "Treasure Not Found", Toast.LENGTH_SHORT).show()
                    }
                }
            })
            {
                Text(text = "Sail West")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                currentDirection.value = "North"
                when {
                    Random.nextBoolean() -> {
                        treasureFound.value += 1
                        Toast.makeText(context, "Treasure Found", Toast.LENGTH_SHORT).show()
                    }

                    else -> {
                        Toast.makeText(context, "Treasure Not Found", Toast.LENGTH_SHORT).show()
                    }
                }
            })
            {
                Text(text = "Sail North")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                currentDirection.value = "South"
                when {
                    Random.nextBoolean() -> {
                        treasureFound.value += 1
                        Toast.makeText(context, "Treasure Found", Toast.LENGTH_SHORT).show()
                    }

                    else -> {
                        Toast.makeText(context, "Treasure Not Found", Toast.LENGTH_SHORT).show()
                    }
                }
            })
            {
                Text(text = "Sail South")
            }
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun GamePreview() {
        captaingame()
    }
}