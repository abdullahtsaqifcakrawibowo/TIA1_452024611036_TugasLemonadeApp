package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    var squeezeTarget by remember { mutableStateOf((2..4).random()) }

    val imageResource = when (currentStep) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val textResource = when (currentStep) {
        1 -> R.string.lemon_tree_text
        2 -> R.string.lemon_squeeze_text
        3 -> R.string.lemon_drink_text
        else -> R.string.lemon_restart_text
    }

    val descResource = when (currentStep) {
        1 -> R.string.lemon_tree_desc
        2 -> R.string.lemon_squeeze_desc
        3 -> R.string.lemon_drink_desc
        else -> R.string.lemon_restart_desc
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(textResource),
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                when (currentStep) {
                    1 -> {
                        squeezeCount = 0
                        squeezeTarget = (2..4).random()
                        currentStep = 2
                    }
                    2 -> {
                        squeezeCount++
                        if (squeezeCount >= squeezeTarget) {
                            currentStep = 3
                        }
                    }
                    3 -> {
                        currentStep = 4
                    }
                    4 -> {
                        currentStep = 1
                    }
                }
            },
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC3E8E3))
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = stringResource(descResource)
            )
        }
    }
}