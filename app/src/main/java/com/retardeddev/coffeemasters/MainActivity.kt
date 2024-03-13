package com.retardeddev.coffeemasters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.retardeddev.coffeemasters.ui.theme.CoffeeMastersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeMastersTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Text( "Hello")
                //                    Greeting("Android")
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 200)
@Preview(showBackground = true)
@Composable
fun FirstComposable() {
    Text(text = "Hello JetPack Compose")
}

@Preview(showBackground = true)
@Composable
fun SecondComposable() {
    Text(text = "Hello JetPack Compose")
}