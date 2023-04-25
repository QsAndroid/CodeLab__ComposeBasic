package com.example.codelab____composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
private fun MyApp (modifier: Modifier = Modifier) {

    androidx.compose.material3.Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Greeting(name = "Android")
    }
}

@Composable
fun Greeting(name: String) {

    androidx.compose.material3.Surface(
        color = MaterialTheme.colorScheme.primary
    ) {

        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(24.dp)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CodeLab____ComposeBasicTheme {
        
        MyApp()
    }
}