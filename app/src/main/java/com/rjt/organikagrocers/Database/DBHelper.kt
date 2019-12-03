package com.rjt.organikagrocers.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.rjt.organikagrocers.Models.ProductModel
import com.rjt.organikagrocers.Models.groceryInventory

class DBHelper(var context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    //Gets the database in writable mode
    private var db: SQLiteDatabase = this.writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_TABLE = "CREATE TABLE if not exists ${TABLE_NAME}(${COLUMN_PRODUCT_ID} INTEGER INCREMENT, ${COLUMN_PRODUCT_NAME} char(100)," +
                "${COLUMN_QUANTITY} char(50), ${COLUMN_PRICE}, ${COLUMN_IMAGE} char(200), ${COLUMN_UNIT})"

        db?.execSQL(CREATE_TABLE)

        Log.d("nijhoom", "onCreate")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        val DROP_TABLE = "DROP TABLE IF EXISTS ${TABLE_NAME}"

        db?.execSQL(DROP_TABLE)

        //Log.d("nijhoom", "onUpgrade")
        onCreate(db)


    }


    fun addProductQty(product: ProductModel){
        if(!ifIteminCart(product))
            addToCart(product)
        else {
            var contentValues = ContentValues()
            contentValues.put(COLUMN_QUANTITY, product.qty)
            db.update(TABLE_NAME, contentValues, "$COLUMN_PRODUCT_ID = ?", arrayOf(product.qty.toString()) )
        }
    }

    //Put information in empty database
    fun addToCart(product: ProductModel){

        val contentValues= ContentValues()

        // Create a new map of values, where column names are the keys
        contentValues.put(COLUMN_PRODUCT_NAME, product.productName)
        contentValues.put(COLUMN_QUANTITY, product.qty)
        contentValues.put(COLUMN_PRICE, product.price)
        contentValues.put(COLUMN_IMAGE, product.image)
        contentValues.put(COLUMN_UNIT, product.unit)

        // Insert the new row, returning the primary key value of the new row
        db.insert(TABLE_NAME, null, contentValues)

    }


    fun ifIteminCart(product: ProductModel): Boolean{


        val query = "Select * from $TABLE_NAME where $COLUMN_PRODUCT_ID=?"
        val cursor = db.rawQuery(query, arrayOf(product._id))
        var count = cursor.count
        if(count == 0)
            return false

        else
        return true
    }

    /*fun readCart(product: ProductModel): Cursor{
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        with(cursor){
            while(moveToNext()){
                val product_Id = getInt(0)
            }
        }

        return cursor
    }*/


    //The columns we'll include in the dictionary table

    companion object{
        const val DATABASE_NAME: String = "GroceryDB"
        const val DATABASE_VERSION: Int = 1
        const val TABLE_NAME: String = "cart"
        const val COLUMN_ID: String = "cart_Id"
        const val COLUMN_PRODUCT_ID: String = "product_Id"
        const val COLUMN_PRODUCT_NAME: String = "product_Name"
        const val COLUMN_QUANTITY: String = "qty"
        const val COLUMN_PRICE: String = "price"
        const val COLUMN_IMAGE: String = "image"
        const val COLUMN_UNIT: String = "_unit"

       /* const val COLUMN_DESCRIPTION: String = "_description"
        const val COLUMN_SUB_ID: String = "sub_Id"
        const val COLUMN_SUB_NAME: String = "sub_Name"
        const val COLUMN_CAT_ID: String = "cat_Id"
        const val COLUMN_CAT_NAME: String = "cat_Name"
        "*/


    }



}