package com.example.codelab____composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codelab____composebasic.ui.theme.CodeLab____ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeLab____ComposeBasicTheme {

                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
private fun MyApp (

    modifier: Modifier = Modifier,
    names : List<String> = listOf("NewWorld", "OldWorld")

) {

    androidx.compose.material3.Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {

        Column(modifier = modifier) {

            for (name in names) {
                Greeting(name = name)
            }
        }

    }
}

@Composable
fun Greeting(name: String) {

    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    androidx.compose.material3.Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)

    ) {

        Row(modifier = Modifier.padding(24.dp)) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)

            ) {

                Text(text = "Hello")
                Text(text = name)
            }

            ElevatedButton(onClick = { expanded.value = !expanded.value }) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }


        /**
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(24.dp)

        )**/
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    CodeLab____ComposeBasicTheme {

        MyApp()
    }
}