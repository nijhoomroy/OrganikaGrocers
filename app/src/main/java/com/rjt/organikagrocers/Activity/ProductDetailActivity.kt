package com.rjt.organikagrocers.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.rjt.organikagrocers.Database.DBHelper
import com.rjt.organikagrocers.Models.ProductModel
import com.rjt.organikagrocers.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.activity_product_detail.view.*
import kotlinx.android.synthetic.main.cart_products_recycler_view.*
import kotlinx.android.synthetic.main.toolbarlayout.*

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product = (intent.getSerializableExtra(ProductModel.PRODUCT) as ProductModel)


        text_view_product_name_detail.text = product.productName
        text_description.text = product.description
        text_view_price_detail.text = "$" + product.price
        text_view_unit.text = product.unit
        text_view_price_detail_bottom.text= "$" + product.price

        Glide
            .with(this)
            .load(product.image)
            .into(image_view_product_image_detail)

        btn_add_to_cart.setOnClickListener{

            val dbHelper = DBHelper(this)
            product.qty = 1
            dbHelper.addToCart(product)

            Toast.makeText(this, "Tada!", Toast.LENGTH_LONG).show()


            /*var intent = Intent(this, CartActivity::class.java)

            startActivity(intent)*/

        }


        setupToolbar()



    }


    private fun setupToolbar() {
        val toolbar: androidx.appcompat.widget.Toolbar = custom_toolbar1
        toolbar?.title= "Item Details"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
            else -> {super.onOptionsItemSelected(item)}
        }
    }
}
