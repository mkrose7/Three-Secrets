package com.example.mkthreesecrets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mkthreesecrets.ui.theme.MkThreeSecretsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MkThreeSecretsTheme {
                ThreeSecretsApp()
            }
        }
    }
}

@Preview
@Composable
fun ThreeSecretsApp() {
    ButtonsAndSecrets(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ButtonsAndSecrets(modifier: Modifier = Modifier) {
var isButtonOneClicked by remember { mutableStateOf(false) }
var isButtonTwoClicked by remember { mutableStateOf(false) }
var isButtonThreeClicked by remember { mutableStateOf(false) }

val textResource1 = when (isButtonOneClicked) {
    false -> R.string.what_is_my_name
    else -> R.string.reveal_secret1
}
val textResource2 = when (isButtonTwoClicked) {
    false -> R.string.the_best_pokemon_is
    else -> R.string.reveal_secret2
}
val textResource3 = when (isButtonThreeClicked) {
    false -> R.string.my_advice_to_the_world_is
    else -> R.string.reveal_secret3
}

val image = painterResource(R.drawable.artwithmkcharacter)
Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text(
        text = stringResource(R.string.three_secrets),
        fontSize = 20.sp,
        modifier = Modifier
            .padding(8.dp)
            .align(alignment = Alignment.CenterHorizontally)
    )
    Spacer(modifier = Modifier.height(30.dp))

    Text(
        text = stringResource(id = textResource1),
        fontSize = 16.sp,
        modifier = Modifier
            .padding(8.dp)
            .align(alignment = Alignment.CenterHorizontally)
    )
    Spacer(modifier = Modifier.height(16.dp))
    Button(onClick = { isButtonOneClicked = (true) }) {
    Text(stringResource(R.string.reveal_secret))
    }
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = stringResource(id = textResource2),
        fontSize = 16.sp,
        modifier = Modifier
            .padding(8.dp)
            .align(alignment = Alignment.CenterHorizontally)
    )
    Spacer(modifier = Modifier.height(16.dp))
    Button(onClick = { isButtonTwoClicked = (true) }) {
        Text(stringResource(R.string.reveal_secret))
    }
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = stringResource(id = textResource3),
        fontSize = 16.sp,
        modifier = Modifier
            .padding(8.dp)
            .align(alignment = Alignment.CenterHorizontally)
    )
    Spacer(modifier = Modifier.height(16.dp))
    Button(onClick = { isButtonThreeClicked = (true) }) {
        Text(stringResource(R.string.reveal_secret))
    }
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .align(alignment = Alignment.CenterHorizontally)
            .padding(top = 100.dp, start = 100.dp, end = 100.dp)
    )
}
}