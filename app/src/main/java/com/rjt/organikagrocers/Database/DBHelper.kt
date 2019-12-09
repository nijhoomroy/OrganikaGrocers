package com.rjt.organikagrocers.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.rjt.organikagrocers.Models.CartModel
import com.rjt.organikagrocers.Models.ProductModel

class DBHelper(var context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    //Gets the database in writable mode
    private var db: SQLiteDatabase = this.writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_TABLE = "CREATE TABLE if not exists ${TABLE_NAME}(${COLUMN_PRODUCT_ID} STRING PRIMARY KEY, ${COLUMN_PRODUCT_NAME} char(100)," +
                "${COLUMN_QUANTITY} char(50), ${COLUMN_PRICE} char(50), ${COLUMN_IMAGE} char(200), ${COLUMN_UNIT} char(50))"

        db?.execSQL(CREATE_TABLE)

        Log.d("nijhoom", "onCreate")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        val DROP_TABLE = "DROP TABLE IF EXISTS ${TABLE_NAME}"

        db?.execSQL(DROP_TABLE)

        //Log.d("nijhoom", "onUpgrade")
        onCreate(db)


    }


    /*fun addProductQty(cart: CartModel){
        if(!isIteminCart(cart))
            addToCart(cart)
        else {
            var contentValues = ContentValues()
            contentValues.put(COLUMN_QUANTITY, cart.qty)
            db.update(TABLE_NAME, contentValues, "$COLUMN_PRODUCT_ID = ?", arrayOf(cart.qty.toString()) )
        }
    }*/

    //Put information in empty database
    fun addToCart(product: ProductModel){

        val cart : CartModel = CartModel(product._id, product.productName, product.qty, product.price.toFloat(), product.image, product.unit)

        if(!isItemInCart(product)){

            val contentValues= ContentValues()

            // Create a new map of values, where column names are the keys
            contentValues.put(COLUMN_PRODUCT_ID, product._id)
            contentValues.put(COLUMN_PRODUCT_NAME, product.productName)
            contentValues.put(COLUMN_QUANTITY, product.qty)
            contentValues.put(COLUMN_PRICE, product.price)
            contentValues.put(COLUMN_IMAGE, product.image)
            contentValues.put(COLUMN_UNIT, product.unit)

            // Insert the new row, returning the primary key value of the new row
            db.insert(TABLE_NAME, null, contentValues)

        } else{

            val contentValues = ContentValues()

            product.qty = product.qty + 1
            contentValues.put(COLUMN_QUANTITY, product.qty)

            cart.qty = product.qty
            updateQuantity(cart)
        }



    }

    fun isItemInCart(product: ProductModel): Boolean{


        val query = "Select * from $TABLE_NAME where $COLUMN_PRODUCT_ID=?"
        val cursor = db.rawQuery(query, arrayOf(product._id.toString()))
        var count = cursor.count
        if(count == 0)
            return false

        else
        return true

        cursor.close()
    }

    fun findExistingQuantity(product: ProductModel): Int{
        val query = "SELECT * FROM $TABLE_NAME where $COLUMN_PRODUCT_ID=?"

        var quantity: Int = 0

        var cursor: Cursor = db.rawQuery(query, arrayOf(product._id.toString()))

        if (cursor.moveToFirst()){
            cursor.getInt(cursor.getColumnIndex(COLUMN_QUANTITY))
            cursor.close()
        }
        return quantity

    }

    fun readCart(): ArrayList<CartModel>{

        val cartList = ArrayList<CartModel>()
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        if (cursor.moveToFirst()) {
            do {
                // Passing values
               val productId = cursor.getString(0)
                val productName: String = cursor.getString(1)
                val qty = cursor.getInt(2)
                val price = cursor.getFloat(3)
                val image = cursor.getString(4)
                val unit = cursor.getString(5)

                cartList.add(CartModel(productId, productName, qty, price, image, unit))

            } while (cursor.moveToNext())


        }
        cursor.close()
        return cartList

    }

    fun updateQuantity(cart: CartModel){
        val contentValues = ContentValues()


        contentValues.put(COLUMN_QUANTITY, cart.qty)

        val whereClause: String = "${COLUMN_PRODUCT_ID} = ?"
        val whereArgs: Array<String> = arrayOf(cart.productId)

        db.update("$TABLE_NAME", contentValues, whereClause, whereArgs)

    }

    fun deleteItem(cart: CartModel){

        val whereClause: String = "${COLUMN_PRODUCT_ID}=?"
        val whereArgs: Array<String> = arrayOf(cart.productId)

        db.delete("${TABLE_NAME}", whereClause, whereArgs)
    }

    //The columns we'll include in the cart table

    companion object{
        const val DATABASE_NAME: String = "GroceryDB"
        const val DATABASE_VERSION: Int = 2
        const val TABLE_NAME: String = "cart"
        const val COLUMN_ID: Int = 0
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
       //const val COLUMN_ID: String = "cart_Id"


    }



}