package com.rjt.organikagrocers.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rjt.organikagrocers.Activity.ProductDetailActivity
import com.rjt.organikagrocers.Database.DBHelper
import com.rjt.organikagrocers.Models.ProductModel
import com.rjt.organikagrocers.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_detail.view.*
import kotlinx.android.synthetic.main.product_list_view.view.*

class ProductListAdapter(val context: Context, var mList: ArrayList<ProductModel>): RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductListAdapter.ViewHolder {

        var view = LayoutInflater.from(context).inflate(R.layout.product_list_view, parent, false)


        return ViewHolder(view)

    }


    override fun getItemCount(): Int {

        return mList.size

    }

    override fun onBindViewHolder(holder: ProductListAdapter.ViewHolder, position: Int) {

        val product = mList.get(position)

        holder.bindView(product, position)

    }

    fun setData(
        list: ArrayList<ProductModel>
    ) {
        mList = list

        notifyDataSetChanged()

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(product: ProductModel, position: Int) {

            itemView.text_view_product_name.text = product.productName
            itemView.text_view_product_price.text = "$" + product.price


            Picasso.get()
                .load(product.image)
                .placeholder(R.drawable.fanta)
                .into(itemView.image_view_product_image)

            /*if (product.productName.contains("Fanta")) {
                itemView.image_view_product_image.setImageResource(R.drawable.fanta)
            }*/

            itemView.setOnClickListener {
                var intent = Intent(context, ProductDetailActivity::class.java)
                intent.putExtra(ProductModel.PRODUCT, product)

                context.startActivity(intent)




            }



        }

    }
}
