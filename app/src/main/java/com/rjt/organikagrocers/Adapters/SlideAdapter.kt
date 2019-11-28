package com.rjt.organikagrocers.Adapters

import android.content.Context
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.FragmentTransitionSupport
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rjt.organikagrocers.Models.HomePageImage
import com.rjt.organikagrocers.R
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.image_slider_adapter.view.*

class SlideAdapter(val mContext: Context, val imageList: ArrayList<HomePageImage>): RecyclerView.Adapter<SlideAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.image_slider_adapter, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

       return imageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val images = imageList.get(position)

        holder.bindView(images, position)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindView(image: HomePageImage, position: Int){

            itemView.image_view_home.setImageResource(image.images)
        }


    }


}