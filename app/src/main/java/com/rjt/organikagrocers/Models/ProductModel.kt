package com.rjt.organikagrocers.Models

import java.io.Serializable

data class ProductModel(val productName: String, val price: String, val description: String, val image: String){

    companion object{
        val PRODUCT: String = "product"
    }

}