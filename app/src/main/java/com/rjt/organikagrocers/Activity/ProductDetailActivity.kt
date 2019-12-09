package com.rjt.organikagrocers.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.rjt.organikagrocers.Adapters.CartListAdapter
import com.rjt.organikagrocers.Database.DBHelper
import com.rjt.organikagrocers.Models.CartModel
import com.rjt.organikagrocers.Models.ProductModel
import com.rjt.organikagrocers.R
import com.rowland.cartcounter.view.CartCounterActionView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.activity_product_detail.view.*
import kotlinx.android.synthetic.main.cart_products_recycler_view.*
import kotlinx.android.synthetic.main.cart_products_recycler_view.view.*
import kotlinx.android.synthetic.main.toolbarlayout.*

class ProductDetailActivity : AppCompatActivity() {
lateinit var dbHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        dbHelper = DBHelper(this)

        val product = (intent.getSerializableExtra(ProductModel.PRODUCT) as ProductModel)


        text_view_product_name_detail.text = product.productName
        text_description.text = product.description
        text_view_price_detail.text = "$" + (product.price)
        text_view_unit.text = product.unit
        text_view_price_detail_bottom.text = "$" + product.price

        Glide
            .with(this)
            .load(product.image)
            .into(image_view_product_image_detail)

        setupToolbar(product)
        displayAddToCart(product)
        buttonClickHandler(product)


    }

    private fun buttonClickHandler(product: ProductModel) {

        val dbHelper = DBHelper(this)

        btn_add_to_cart.setOnClickListener {
            product.qty = 1
            dbHelper.addToCart(product)

            btn_add_to_cart.visibility = View.GONE
            layout_qty_detail.visibility = View.VISIBLE
        }


           btn_add_inproductdetail.setOnClickListener {

               var updatedQty = dbHelper.findExistingQuantity(product)

                product.qty = updatedQty + 1
                dbHelper.updateQuantity(product)
               text_view_qty_inproductdetail.text = (product.qty).toString()

            }
            btn_remove_inproductdetail.setOnClickListener {

                text_view_qty_inproductdetail.text = (product.qty).toString()

                var updatedQty = dbHelper.findExistingQuantity(product)

                if (updatedQty == 1) {

                    dbHelper.deleteItem(product)

                    layout_qty_detail.visibility = View.GONE
                    btn_add_to_cart.visibility = View.VISIBLE

                } else {

                    product.qty = updatedQty - 1
                    dbHelper.updateQuantity(product)

                    text_view_qty_inproductdetail.text = (product.qty).toString()


                }

            }

    }

    private fun displayAddToCart(product: ProductModel){
        if(dbHelper.isItemInCart(product)) {

        btn_add_to_cart.visibility = View.GONE
        layout_qty_detail.visibility = View.VISIBLE

    }
    else{

        btn_add_to_cart.visibility = View.VISIBLE
        layout_qty_detail.visibility = View.GONE

    }
}

    private fun setupToolbar(product:ProductModel) {
        val toolbar: androidx.appcompat.widget.Toolbar = custom_toolbar1
        toolbar?.title= product.productName
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {

        val cartToolbar = menu.findItem(R.id.btn_cart_toolbar)
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.btn_cart_toolbar -> {
                val intent: Intent = Intent(this, CartActivity::class.java)

                startActivity(intent)

                return true
            }
            else -> {super.onOptionsItemSelected(item)}
        }
    }



}



/* //dbHelper.updateQuantity(cart)

    *//*if (dbHelper.ifIteminCart(cart)){

                val quantityText: TextView = findViewById(R.id.text_view_qty_cart)

                cart.qty = cart.qty+1
                dbHelper.updateQuantity(cart)

                text_view_qty_cart.text = cart.qty.toString()

                val intent: Intent = Intent(this, CartActivity::class.java)
                startActivity(intent)

                //notifyDataSetChanged()
            }

            else {cart.qty = 1
            dbHelper.addToCart(cart)

            Toast.makeText(this, "Tada!", Toast.LENGTH_LONG).show()
            }
*//*

            var intent = Intent(this, CartActivity::class.java)

            startActivity(intent)
*/
