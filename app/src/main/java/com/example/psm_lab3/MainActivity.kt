package com.example.psm_lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.example.psm_lab3.ui.theme.PSM_Lab3Theme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.pluralStringResource
import android.app.LocaleManager
import android.os.Build
import android.os.LocaleList
import androidx.compose.foundation.layout.width

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
    var viewedJokesCount by remember { mutableIntStateOf(1) }

    val context = LocalContext.current
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
            onClick = {
                currentJokeIndex = jokes.indices.random()
                viewedJokesCount++
            },
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

        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        val localeManager = context.getSystemService(LocaleManager::class.java)
                        localeManager.applicationLocales = LocaleList.forLanguageTags("pl")
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = pastelPink)
            ) {
                Text(text = "PL", color = deepPink, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        val localeManager = context.getSystemService(LocaleManager::class.java)
                        localeManager.applicationLocales = LocaleList.forLanguageTags("en")
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = pastelPink)
            ) {
                Text(text = "EN", color = deepPink, fontWeight = FontWeight.Bold)
            }
        }


        Text(
            text = pluralStringResource(
                id = R.plurals.jokes_viewed_count,
                count = viewedJokesCount,
                viewedJokesCount
            ),
            textAlign = TextAlign.Center,
            color = deepPink,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = stringResource(
                id = R.string.greeting,
                stringResource(id = R.string.guest_name),
                viewedJokesCount
            ),
            textAlign = TextAlign.Center,
            color = deepPink
        )
    }
}

