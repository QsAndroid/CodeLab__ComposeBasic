package com.example.codelab____composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
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
private fun MyApp (modifier: Modifier = Modifier, ) {

    var shouldShowOnboarding by remember { mutableStateOf(true) }

    Surface(modifier) {

        if (shouldShowOnboarding)
            OnboardingScreen(onContinueClicked = {shouldShowOnboarding = false})
        else
            Greetings()

    }
}

@Composable
private fun Greetings (
    modifier: Modifier = Modifier,
    names : List<String> = List(1000) { "$it" }
) {

    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {

        items(items = names) { name ->
            Greeting(name = name)
        }
    }

}

@Composable
fun Greeting(name: String) {

    val expanded = rememberSaveable { mutableStateOf(false) }
    val extraPadding by animateDpAsState (
        if (expanded.value) 48.dp else 0.dp,

        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow

            )

        )

    androidx.compose.material3.Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)

    ) {

        Row(modifier = Modifier.padding(24.dp)) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))

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

@Composable
fun OnboardingScreen (
    onContinueClicked : () -> Unit,
    modifier: Modifier = Modifier
) {

    //var shouldShowOnboarding by remember { mutableStateOf(true) }

    Column(

        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

        ) {

        Text(text = "Welcome to the Basics Codelab!!!")

        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick =  onContinueClicked
        ) {

            Text(text = "Continue")
        }



    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    CodeLab____ComposeBasicTheme {

        //MyApp()
        Greetings()
    }
}

@Preview
@Composable
fun MyAppPreview () {
    CodeLab____ComposeBasicTheme {
        MyApp(Modifier.fillMaxSize())

    }
}