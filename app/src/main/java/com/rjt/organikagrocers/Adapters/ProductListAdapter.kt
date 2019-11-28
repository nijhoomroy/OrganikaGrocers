package com.rjt.organikagrocers.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rjt.organikagrocers.Models.ProductModel
import com.rjt.organikagrocers.R
import com.squareup.picasso.Picasso
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

    fun setData(list: ArrayList<ProductModel>) {
        mList = list

        notifyDataSetChanged()

    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindView(product:ProductModel, position: Int){

            itemView.text_view_category_name.text = product.productName

            /*Picasso.with(context)
                .load(product.image)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(itemView.image_view_product_image)*/

            /*itemView.setOnClickListener{
                var intent = Intent(context, ProductBuy::class.java)
                intent.putExtra(ProductModel.PRODUCT, product)

                context.startActivity(intent)*/



            }

        }

    }
