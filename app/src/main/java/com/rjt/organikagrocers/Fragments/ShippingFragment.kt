package com.rjt.organikagrocers.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rjt.organikagrocers.Adapters.PaymentAdapter
import com.rjt.organikagrocers.Models.Payment

import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.fragment_shipping.view.*

/**
 * A simple [Fragment] subclass.
 */
class ShippingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_shipping, container, false)

        var paymentList = ArrayList<Payment>()

        paymentList.add(Payment("Credit or Debit Card", R.drawable.creditcard))
       paymentList.add(Payment("PayPal", R.drawable.paypallogo))
        paymentList.add(Payment("Google Pay", R.drawable.googlepay))

        val paymentAdapter = PaymentAdapter(this.activity!!, paymentList)

        view.payment_list_view.adapter = paymentAdapter


        return view
    }


}
