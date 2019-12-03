package com.rjt.organikagrocers.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rjt.organikagrocers.Fragments.ProductFragment
import com.rjt.organikagrocers.Models.SubCategoryModel
import com.rjt.organikagrocers.R

class FragAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){

    var mTitleList: ArrayList<String> = ArrayList<String>()
    var mFragmentList: ArrayList<Fragment> = ArrayList<Fragment>()


    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
       return mTitleList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitleList.get(position)
    }

    fun addFragment(subCategory: SubCategoryModel){
        mFragmentList.add(ProductFragment.newInstance(subCategory.subId))
        mTitleList.add(subCategory.subName)

    }




}

