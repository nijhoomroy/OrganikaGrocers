package com.rjt.organikagrocers.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.rjt.organikagrocers.Models.Payment
import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.payment_list_view.view.*

class PaymentAdapter(private val mContext: Context, private val PaymentList: ArrayList<Payment>):
    BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(mContext).inflate(R.layout.payment_list_view, parent, false)


        view.image_view_payment.setImageResource(PaymentList.get(position).imgae)
        view.text_view_payment_type.text = PaymentList.get(position).name



        return view


    }

    override fun getItem(position: Int): Any {
        return PaymentList.get(position)

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()

    }

    override fun getCount(): Int {
        return PaymentList.size

    }
}