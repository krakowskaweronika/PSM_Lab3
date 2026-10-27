package com.example.psm_lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.example.psm_lab3.ui.theme.PSM_Lab3Theme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PSM_Lab3Theme {
                JokeScreen()

                }
            }
        }
    }


@Composable
fun JokeScreen() {
    val pastelPink = Color(0xFFFCE4EC)
    val deepPink = Color(0xFFD85887)

    val jokes = stringArrayResource(id = R.array.jokes_array)

    var currentJokeIndex by remember { mutableIntStateOf(jokes.indices.random()) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = deepPink,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Text(
            text = jokes[currentJokeIndex],
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = { currentJokeIndex = jokes.indices.random()},
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = deepPink),
            modifier = Modifier.size(150.dp)
        ) {
            Text(
                text = stringResource(id = R.string.button_show_joke),
                textAlign = TextAlign.Center,
                color = pastelPink
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = stringResource(id = R.string.greeting, "Weronika", 1),
            textAlign = TextAlign.Center,
            color = deepPink
        )
    }

}