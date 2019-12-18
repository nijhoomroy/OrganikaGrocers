package com.rjt.organikagrocers.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rjt.organikagrocers.Adapters.CartListAdapter
import com.rjt.organikagrocers.Class.ClickListener
import com.rjt.organikagrocers.Database.DBHelper
import com.rjt.organikagrocers.Fragments.OrderFragment
import com.rjt.organikagrocers.Models.CartModel
import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.activity_cart.*


class CartActivity : AppCompatActivity(), ClickListener {

    var cart:CartModel = CartModel("","", 0, 0.0F, "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)


        var list: ArrayList<CartModel> = ArrayList<CartModel>()
        var adapter2: CartListAdapter? = null



        val dbHelper = DBHelper(this)
        list = dbHelper.readCart()


        recycler_view_cart.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        adapter2 = CartListAdapter(this, list, this)
        recycler_view_cart.adapter = adapter2


        //list = dbHelper.readCart()



        setupToolbar()
        getTotal()
        proceedToCheckout()




    }

   private fun getTotal() {


       val dbHelper = DBHelper(this)

       var price = dbHelper.getTotalPrice()


       text_view_amount_total.text = "$%.2f ".format(price).toString()

       val myPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)

       var editor = myPref.edit()

       editor.putFloat("subtotal", price)

       editor.commit()


   }

    private fun proceedToCheckout() {


        btn_proceedtocheckout.setOnClickListener{

            var amount = text_view_amount_total.text.toString()

            //var orderFragment = OrderFragment.newInstance(amount)

            val intent = Intent(this, CheckoutActivity::class.java)

            startActivity(intent)
        }
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

    override fun onQuantityChange() {

        getTotal()

    }


}
