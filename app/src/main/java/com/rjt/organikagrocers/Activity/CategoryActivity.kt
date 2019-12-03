package com.rjt.organikagrocers.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import com.rjt.organikagrocers.Adapters.ProductListAdapter
import com.rjt.organikagrocers.Adapters.SlideAdapter
import com.rjt.organikagrocers.Models.HomePageImage
import com.rjt.organikagrocers.Models.ProductModel
import com.rjt.organikagrocers.Models.ProductModelList
import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_sub_category.*

class CategoryActivity : AppCompatActivity() {

    val imagelist = ArrayList<HomePageImage>()

    var adapter2: ProductListAdapter? = null
    var list: ArrayList<ProductModel> = ArrayList<ProductModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        /*     imageSlider()
        getData()
    }

    private fun imageSlider() {

        imagelist.add(HomePageImage(R.drawable.healthychoices))


        var adapter1 = SlideAdapter(this, imagelist)
        view_pager_category.adapter = adapter1

        product_list_recycler_view.layoutManager = LinearLayoutManager(this)
        adapter2 = ProductListAdapter(this, list)
        product_list_recycler_view.adapter = adapter2
    }

    private fun getData(){

        val url: String = "http://rjtmobile.com/grocery/products.json"
        var requestQueue = Volley.newRequestQueue(this)
        var stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener { response ->
                val gson = GsonBuilder().create()
                val data: ProductModelList = gson.fromJson(response.toString(), ProductModelList::class.java)
                adapter2?.setData(data.data)
            }, Response.ErrorListener { Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show() })

        requestQueue.add(stringRequest)
    }*/
    }
}
