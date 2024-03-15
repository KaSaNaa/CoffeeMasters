package com.retardeddev.coffeemasters

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.frontendmasters.coffeemasters.OffersPage
import com.retardeddev.coffeemasters.ui.theme.CoffeeMastersTheme
import com.retardeddev.coffeemasters.ui.theme.Primary

@Preview
@Composable
fun AppPreview() {
    CoffeeMastersTheme {
        App()
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    AppTitle()
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Primary
                ),
            )
        },
        bottomBar = {},
        content = {
            OffersPage()
        }
    )
}

@Preview
@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo")
    }
}