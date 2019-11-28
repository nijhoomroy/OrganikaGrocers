package com.rjt.organikagrocers.Activity

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import com.rjt.organikagrocers.Adapters.SlideAdapter
import com.rjt.organikagrocers.Class.SessionManager
import com.rjt.organikagrocers.Models.HomePageImage
import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {


    val imagelist = ArrayList<HomePageImage>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        imageSlider()

        text_view_start_shopping.setOnClickListener{

            val intent: Intent = Intent(this, CategoryActivity::class.java)

            startActivity(intent)
        }

        btn_logout.setOnClickListener{

//            SessionManager().setLogOut(this.a)
        }




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


    }





