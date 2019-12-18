package com.rjt.organikagrocers.Activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.widget.ToolbarWidgetWrapper
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.rjt.organikagrocers.Adapters.CheckoutFragAdapter
import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.toolbarlayout.*
import kotlinx.android.synthetic.main.toolbarwithoutcart.*


class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val fragAdapter = CheckoutFragAdapter(this.supportFragmentManager)

        view_pager_checkout.adapter = fragAdapter

        tab_layout_checkout.setupWithViewPager(view_pager_checkout)

        tab_layout_checkout.getTabAt(0)?.setIcon(R.drawable.address)
        tab_layout_checkout.getTabAt(1)?.setIcon(R.drawable.cardpayment)
        tab_layout_checkout.getTabAt(2)?.setIcon(R.drawable.truckdelivery)

        setupToolbar()


    }


    private fun setupToolbar() {
        var toolbar : Toolbar = custom_toolbar1
        toolbar.title = "Order Details"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


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
