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
import com.rjt.organikagrocers.Models.CartModel
import com.rjt.organikagrocers.Models.ProductModel
import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.cart_products_recycler_view.view.*

class CartListAdapter(
    val context: Context,
    var mList: ArrayList<CartModel>
): RecyclerView.Adapter<CartListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartListAdapter.ViewHolder {

        var view = LayoutInflater.from(context).inflate(R.layout.cart_products_recycler_view, parent, false)


        return ViewHolder(view)

    }


    override fun getItemCount(): Int {

        return mList.size

    }

    override fun onBindViewHolder(holder: CartListAdapter.ViewHolder, position: Int) {

        val cart = mList.get(position)

        holder.bindView(cart, position)

    }

    fun setData(
        list: ArrayList<CartModel>
    ) {
        mList = list

        notifyDataSetChanged()

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val dbHelper = DBHelper(context)

        fun bindView(cart: CartModel, position: Int) {

            itemView.text_view_name_cart.text = cart.name
            itemView.text_view_price_cart.text = "$" + cart.price.toString()
            itemView.text_view_unit_cart.text = cart.unit
            itemView.text_view_qty_cart.text = cart.qty.toString()
            Glide
                .with(context)
                .load(cart.image)
                .into(itemView.image_view_cart)

            itemView.btn_add_cart.setOnClickListener {

                //var cartQty: String = itemView.text_view_qty_cart.text.toString()

                itemView.text_view_qty_cart.text = (cart.qty).toString()


                    mList[position].qty += 1
                    dbHelper.updateQuantity(cart)
                    notifyDataSetChanged()

                /*var subTotal_item:String = (cart.qty*cart.price).toString()

                itemView.text_view_price_cart.text.toString() = subTotal_item
*/

            }

            itemView.btn_remove_cart.setOnClickListener {

                itemView.text_view_qty_cart.text = (cart.qty).toString()

                    if (mList[position].qty ==1 ) {

                            mList.removeAt(position)
                            dbHelper.deleteItem(cart)
                            notifyDataSetChanged()



                    }
                    else{


                    mList[position].qty -= 1
                        dbHelper.updateQuantity(cart)
                       notifyDataSetChanged()}

                }





        }



        }

    }

