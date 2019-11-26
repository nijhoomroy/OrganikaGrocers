package com.rjt.organikagrocers.Models

data class groceryInventory(
    var productId: String, var productName: String, var subId: Int, var subName: String, var catId: Int,
    var catName: String, var quantity: Int, var unit: Int, var price: Int, var description: String, var image: String)