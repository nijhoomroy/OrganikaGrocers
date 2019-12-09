package com.rjt.organikagrocers.Models

data class CartModel(val productId: String, val name: String, var qty: Int, var price: Float, val image: String, val unit: String)