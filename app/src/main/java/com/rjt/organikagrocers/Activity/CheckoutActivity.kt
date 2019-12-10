package com.rjt.organikagrocers.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.rjt.organikagrocers.Adapters.CheckoutFragAdapter
import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.activity_checkout.*


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


    }
}
