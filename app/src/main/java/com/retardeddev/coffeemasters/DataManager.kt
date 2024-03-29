package com.retardeddev.coffeemasters

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DataManager (app: Application): AndroidViewModel(app){
    var menu: List<Category> by mutableStateOf(listOf())
    var cart: List<ItemInCart> by mutableStateOf(listOf())

    init {
        fetchData()
    }

    private fun fetchData(){
        viewModelScope.launch {
            API.menuService.fetchMenu()
        }
    }

    fun cartRemove(product: Product){
        val aux = cart.toMutableList()
        aux.removeAll{ it.product.id == product.id }

        cart = listOf(*aux.toTypedArray())
    }

    fun cartClear(){
        cart = listOf()
    }

    fun cartAdd(product: Product){
        var found = false
        cart.forEach{
            if(product.id == it.product.id){
                it.quantity++
                found = true
            }
        }
        if (!found){
            cart = listOf(*cart.toTypedArray(), ItemInCart(product, 1))
        }
    }

}