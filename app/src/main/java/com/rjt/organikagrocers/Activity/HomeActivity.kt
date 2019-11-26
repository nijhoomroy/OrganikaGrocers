package com.rjt.organikagrocers.Activity

import android.app.Activity
import android.app.SearchManager
import android.content.ClipData
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import com.rjt.organikagrocers.Adapters.ViewPagerAdapter
import com.rjt.organikagrocers.Class.RxSearchObservable
import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.activity_home.*
import rx.Subscriber
import rx.internal.operators.OperatorReplay.observeOn
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class HomeActivity : AppCompatActivity() {

    val images = arrayOf<Int>(R.drawable.christmasretail, R.drawable.healthychoices)
     var viewPagerAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        view_pager_home.adapter = viewPagerAdapter




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
        }*/


    }





