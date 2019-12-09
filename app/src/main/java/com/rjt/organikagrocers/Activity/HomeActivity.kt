package com.rjt.organikagrocers.Activity

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.GsonBuilder
import com.rjt.organikagrocers.Adapters.CategoryListAdapter
import com.rjt.organikagrocers.Adapters.ProductListAdapter
import com.rjt.organikagrocers.Adapters.SlideAdapter
import com.rjt.organikagrocers.Class.SessionManager
import com.rjt.organikagrocers.Fragments.LoginFragment
import com.rjt.organikagrocers.Models.*
import com.rjt.organikagrocers.Notifications.NotificationActivity
import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_notification.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.toolbarlayout.*

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{


    val imagelist = ArrayList<HomePageImage>()

    var categoryAdapter: CategoryListAdapter? = null
    var categoryList: ArrayList<CategoryModel>  = ArrayList<CategoryModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation_menu)

        bottomNavigation.setOnNavigationItemSelectedListener(this)

        imageSlider()

        getData()

        category_recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryAdapter = CategoryListAdapter(this, categoryList)
        category_recycler_view.adapter = categoryAdapter


       /* btn_logout.setOnClickListener{

            SessionManager().setLogOut(this, false)

            supportFragmentManager.beginTransaction().add(R.id.fragment_loginregister_container, LoginFragment()).commit()
        }
*/
        btn_cart.setOnClickListener{

            var intent: Intent = Intent(this, CartActivity()::class.java)
            startActivity(intent)
        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.search_view_search)?.actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))


        }

        return true
    }



    private fun imageSlider(){
        imagelist.add(HomePageImage(R.drawable.merrychristmas))
        imagelist.add(HomePageImage(R.drawable.christmasretail))


        var adapter = SlideAdapter(this, imagelist)
        view_pager_home.adapter = adapter
        dots_indicator.setViewPager2(view_pager_home)



    }

    private fun getData(){
        val url: String = "https://apolis-grocery.herokuapp.com/api/category"
        var requestQueue = Volley.newRequestQueue(this)
        var stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener { response ->
                val gson = GsonBuilder().create()
                val data: CategoryModelList? = gson.fromJson(response.toString(), CategoryModelList::class.java)
                if (data != null) {
                    categoryAdapter?.setData(data.data)

                    progress_bar.visibility = View.GONE
                }
            }, Response.ErrorListener { Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show() })

        requestQueue.add(stringRequest)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.getItemId()) {
            R.id.btn_home -> {
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











