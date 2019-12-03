package com.rjt.organikagrocers.Adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rjt.organikagrocers.Activity.SubCategoryActivity
import com.rjt.organikagrocers.Models.CategoryModel
import com.rjt.organikagrocers.Models.ProductModel
import com.rjt.organikagrocers.R
import com.rjt.organikagrocers.R.drawable.dairy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.category_section.view.*
import java.util.*
import kotlin.collections.ArrayList

class CategoryListAdapter(val context: Context, var mList: ArrayList<CategoryModel>): RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {

    val categoryImageList = arrayOf(R.drawable.beverages, R.drawable.dairy, R.drawable.fruits2, R.drawable.bakery2)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryListAdapter.ViewHolder {

        var view = LayoutInflater.from(context).inflate(R.layout.category_section, parent, false)


        return ViewHolder(view)

    }



    override fun getItemCount(): Int {

        return mList.size

    }

    override fun onBindViewHolder(holder: CategoryListAdapter.ViewHolder, position: Int) {

        val category = mList.get(position)


        holder.bindView(category, position)

    }

    fun setData(list: ArrayList<CategoryModel>) {
        mList = list

        notifyDataSetChanged()

    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindView(category:CategoryModel, position: Int) {

            itemView.text_view_category_name.text = category.catName

            if (category.catId == 1)

                itemView.image_view_category_image.setImageResource(R.drawable.beverages1)

            if (category.catId == 2)

                itemView.image_view_category_image.setImageResource(R.drawable.dairy1)

            if (category.catId == 3)

                itemView.image_view_category_image.setImageResource(R.drawable.veggies)

            if (category.catId == 4)

                itemView.image_view_category_image.setImageResource(R.drawable.bakery)


            itemView.setOnClickListener{

                var intent = Intent(context, SubCategoryActivity::class.java)

               /* val bundle: Bundle = Bundle()

                bundle.putString("CATEGORY", category.catName)
                intent.putExtras(bundle)


                context.startActivity(intent)*/

                intent.putExtra(CategoryModel.CATEGORY, category)
                context.startActivity(intent)



        }
        }
}}