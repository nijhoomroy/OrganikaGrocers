package com.rjt.organikagrocers.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.rjt.organikagrocers.R
import java.util.*


class ViewPagerAdapter(var context: Context): PagerAdapter() {

    val images = arrayOf<Int>(R.drawable.christmasretail, R.drawable.healthychoices)
    lateinit var inflater: LayoutInflater

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return `object` == view
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val imageLayout = inflater.inflate(R.layout.viewpageradapter, container, false)!!

        val imageView = imageLayout
            .findViewById(R.id.image_slider) as ImageView


        imageView.setImageResource(images[position])

        container.addView(imageLayout, 0)

        return imageLayout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }


}
