package com.rjt.organikagrocers.Models

import java.io.Serializable

data class ProductModel(var _id: String, val productName: String, val price: String, val description: String, val subId: Int, val unit: String, var qty: Int, val image: String):Serializable{

    companion object{
        val PRODUCT: String = "product"
        val CART_PRODUCT: String = "cartProduct"
    }

}