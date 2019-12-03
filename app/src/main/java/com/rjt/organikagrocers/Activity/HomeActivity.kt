package com.rjt.organikagrocers.Activity

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import com.rjt.organikagrocers.Adapters.CategoryListAdapter
import com.rjt.organikagrocers.Adapters.ProductListAdapter
import com.rjt.organikagrocers.Adapters.SlideAdapter
import com.rjt.organikagrocers.Class.SessionManager
import com.rjt.organikagrocers.Fragments.LoginFragment
import com.rjt.organikagrocers.Models.*
import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {


    val imagelist = ArrayList<HomePageImage>()

    var categoryAdapter: CategoryListAdapter? = null
    var categoryList: ArrayList<CategoryModel>  = ArrayList<CategoryModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

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





    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.search_view_search)?.actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))



        }

        return true
    }


    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.btn_home-> {true}
            R.id.btn_order_again -> {true}
            R.id.btn_category -> {true}
            R.id.btn_user -> {true}
            else -> {true}
        }
*/
    private fun imageSlider(){
        imagelist.add(HomePageImage(R.drawable.merrychristmas))
        imagelist.add(HomePageImage(R.drawable.christmasretail))


        var adapter = SlideAdapter(this, imagelist)
        view_pager_home.adapter = adapter



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
                }
            }, Response.ErrorListener { Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show() })

        requestQueue.add(stringRequest)
    }
    }








