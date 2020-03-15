package com.rjt.organikagrocers.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.GsonBuilder
import com.rjt.organikagrocers.Adapters.FragAdapter
import com.rjt.organikagrocers.Adapters.ProductListAdapter
import com.rjt.organikagrocers.Fragments.ProductFragment
import com.rjt.organikagrocers.Models.*
import com.rjt.organikagrocers.Notifications.NotificationActivity
import com.rjt.organikagrocers.R
import com.rowland.cartcounter.view.CartCounterActionView
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.activity_sub_category.*
import kotlinx.android.synthetic.main.cart_layout.*
import kotlinx.android.synthetic.main.toolbarlayout.*
import java.lang.reflect.Method


class SubCategoryActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    var fragAdapter: FragAdapter? = null

    //val category: CategoryModel = (intent.getSerializableExtra(CategoryModel.CATEGORY) as CategoryModel)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_category)

        val category: CategoryModel = (intent.getSerializableExtra(CategoryModel.CATEGORY) as CategoryModel)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation_menu)

        bottomNavigation.setOnNavigationItemSelectedListener(this)

        setupToolbar(category)
        init()

        }

    private fun setupToolbar(category: CategoryModel) {
        val toolbar: androidx.appcompat.widget.Toolbar = custom_toolbar1
        toolbar.title= category.catName
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        val menuItem = menu.findItem(R.id.btn_cart_toolbar)

        /*val actionView = MenuItemCompat.getActionProvider(menuItem)

        val textItemCount: TextView = actionView.context(R.id.text_view_cart_badge) as TextView

        text_view_cart_badge.visibility = View.VISIBLE

        setupBadge()
*/
        return super.onCreateOptionsMenu(menu)
    }

    /*private fun setupBadge() {
       // if(textCartItemCount)
    }*/

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {

        val cartToolbar = menu.findItem(R.id.btn_cart_toolbar)
        return super.onPrepareOptionsMenu(menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.btn_cart_toolbar -> {
                val intent: Intent = Intent(this, CartActivity::class.java)

                startActivity(intent)

                return true
            }
            else -> {super.onOptionsItemSelected(item)}
        }
    }

        private fun init() {

            fragAdapter = FragAdapter(supportFragmentManager)
            for(subCategory in getSubCategory()) {
                fragAdapter?.addFragment(subCategory)}

                view_pager_subcategory.adapter = fragAdapter
                tab_layout_subcategory.setupWithViewPager(view_pager_subcategory)


        }




        private fun getSubCategory(): ArrayList<SubCategoryModel>{
            var list: ArrayList<SubCategoryModel> = ArrayList<SubCategoryModel>()
           // val bundle: Bundle? = intent.getExtras()

           //var categoryName: String? = bundle?.getString("CATEGORY")
            val category: CategoryModel = (intent.getSerializableExtra(CategoryModel.CATEGORY) as CategoryModel)



            if (category.catId == 1){

                list.add(SubCategoryModel(1,"Soft Drinks"))
                list.add(SubCategoryModel(2, "Fruit Juice"))
                list.add(SubCategoryModel(3,"Coffee"))

            }

            if (category.catId == 2) {

                list.add(SubCategoryModel(4,"Milk"))
                list.add(SubCategoryModel(5, "Cheese"))
                list.add(SubCategoryModel(6,"Yogurt"))


            }

            if (category.catId == 3){

                list.add(SubCategoryModel(7, "Fruits"))
                list.add(SubCategoryModel(8, "Vegetables"))



            }

            if (category.catId == 4){
                list.add(SubCategoryModel(9, "Cookies"))
                list.add(SubCategoryModel(10,"Desserts"))


            }


            return list
        }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.btn_home -> {
                var intent = Intent(this, HomeActivity::class.java)

                startActivity(intent)
                return true
            }
            R.id.btn_order_again -> {

                return true
            }
            R.id.btn_notification -> {
                var intent = Intent(this, NotificationActivity::class.java)

                startActivity(intent)
            }
            R.id.btn_user -> {
                var intent = Intent(this, AccountActivity::class.java)

                startActivity(intent)

                return true
            }

            else -> {return true}
        }
        return false
    }
    }



