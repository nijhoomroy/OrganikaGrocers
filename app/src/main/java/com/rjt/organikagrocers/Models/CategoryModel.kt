package com.rjt.organikagrocers.Models

import java.io.Serializable

data class CategoryModel (val catId: Int, val catName: String, val catImage: String):Serializable {

    companion object {

        val CATEGORY: String = "category"

    }
}
