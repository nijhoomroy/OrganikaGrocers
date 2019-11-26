package com.rjt.organikagrocers.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.rjt.organikagrocers.Models.groceryInventory

class DBHelper(var context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_TABLE = "CREATE TABLE ${TABLE_NAME}(${COLUMN_PRODUCT_ID}, ${COLUMN_PRODUCT_NAME} char(100), ${COLUMN_SUB_ID}, ${COLUMN_SUB_NAME} char(100)," +
                "${COLUMN_CAT_ID}, ${COLUMN_CAT_NAME} char(100), ${COLUMN_QUANTITY}, ${COLUMN_UNIT}, ${COLUMN_PRICE}, ${COLUMN_DESCRIPTION}, ${COLUMN_IMAGE})"

        db?.execSQL(CREATE_TABLE)

        Log.d("nijhoom", "onCreate")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        val DROP_TABLE = "DROP TABLE IF EXISTS ${TABLE_NAME}"

        db?.execSQL(DROP_TABLE)

        Log.d("nijhoom", "onUpgrade")


    }

    fun addInventory(arrayList: ArrayList<groceryInventory> ){

        val db = this.writableDatabase
        val contentValues= ContentValues()

        contentValues.put(COLUMN_PRODUCT_ID, "product_Id")
        contentValues.put(COLUMN_PRODUCT_NAME, "product_Name")
        contentValues.put(COLUMN_SUB_ID, "sub_Id")
        contentValues.put(COLUMN_SUB_NAME, "sub_Name")
        contentValues.put(COLUMN_CAT_ID, "cat_Id")
        contentValues.put(COLUMN_CAT_NAME, "cat_Name")
        contentValues.put(COLUMN_QUANTITY, "_quantity")
        contentValues.put(COLUMN_UNIT, "_unit")
        contentValues.put(COLUMN_PRICE, "_price")
        contentValues.put(COLUMN_DESCRIPTION, "_description")
        contentValues.put(COLUMN_IMAGE, "_images")





    }


    //The columns we'll include in the dictionary table

    companion object{
        const val DATABASE_NAME: String = "GroceryDB"
        const val DATABASE_VERSION: Int = 1
        const val TABLE_NAME: String = "groceryInventory"
        const val COLUMN_PRODUCT_ID: String = "product_Id"
        const val COLUMN_PRODUCT_NAME: String = "product_Name"
        const val COLUMN_SUB_ID: String = "sub_Id"
        const val COLUMN_SUB_NAME: String = "sub_Name"
        const val COLUMN_CAT_ID: String = "cat_Id"
        const val COLUMN_CAT_NAME: String = "cat_Name"
        const val COLUMN_QUANTITY: String = "_quantity"
        const val COLUMN_UNIT: String = "_unit"
        const val COLUMN_PRICE: String = "_price"
        const val COLUMN_DESCRIPTION: String = "_description"
        const val COLUMN_IMAGE: String = "_image"


    }



}