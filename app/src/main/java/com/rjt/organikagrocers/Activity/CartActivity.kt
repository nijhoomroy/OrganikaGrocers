package com.rjt.organikagrocers.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rjt.organikagrocers.Adapters.CartListAdapter
import com.rjt.organikagrocers.Database.DBHelper
import com.rjt.organikagrocers.Models.CartModel
import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.toolbarlayout.*

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        var list: ArrayList<CartModel> = ArrayList<CartModel>()
        var adapter2: CartListAdapter? = null



        val dbHelper = DBHelper(this)
        list = dbHelper.readCart()


        recycler_view_cart.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        adapter2 = CartListAdapter(this, list)
        recycler_view_cart.adapter = adapter2


        //list = dbHelper.readCart()

        setupToolbar()


    }

    private fun setupToolbar() {

        val toolbar: androidx.appcompat.widget.Toolbar? = findViewById(R.id.toolbar)
        toolbar?.title= "Cart"
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
            else -> {super.onOptionsItemSelected(item)}
        }
    }


}
