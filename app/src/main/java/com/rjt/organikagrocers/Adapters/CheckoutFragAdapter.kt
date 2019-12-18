package com.rjt.organikagrocers.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rjt.organikagrocers.Fragments.CustomerInfo
import com.rjt.organikagrocers.Fragments.OrderFragment
import com.rjt.organikagrocers.Fragments.ShippingFragment

class CheckoutFragAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> CustomerInfo()
            1 -> ShippingFragment()
            else -> OrderFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "Ship"
            1 -> "Pay"
            else -> "Order"
        }
    }


}