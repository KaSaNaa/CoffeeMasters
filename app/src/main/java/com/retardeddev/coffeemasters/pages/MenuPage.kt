package com.retardeddev.coffeemasters.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.coffeemasters.DataManager
import com.retardeddev.coffeemasters.Product
import com.retardeddev.coffeemasters.R
import com.retardeddev.coffeemasters.ui.theme.Alternative1
import com.retardeddev.coffeemasters.ui.theme.CardBackground

@Preview
@Composable
fun MenuPage(dataManager: DataManager) {
    LazyColumn {
        items(5){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CardBackground)
                    .padding(12.dp)
                    .height(250.dp)
            ) {
                ProductItem(Product(1, "Black", 100.0, image = "black_coffee"), {})
            }
        }
    }
}


fun Double.format(digits: Int) = "%.${digits}f".format(this)

@Composable
fun ProductItem_Preview( product: Product = Product(1, "Black", 100.0, image = "")) {
    ProductItem(product = product, onAdd = {})
    
}

@Composable
fun ProductItem(product: Product, onAdd: (Product)->Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        Image(
            painter = painterResource(id = R.drawable.black_coffee),
            contentDescription = "Image for ${product.name}",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(product.name, fontWeight = FontWeight.Bold)
                Text("$${product.price.format(2)} ea")
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Alternative1,
                    contentColor = Color.White
                ),
                onClick = {
                    onAdd(product)
                },
            ) {
                Text("Add")
            }
        }
    }
}