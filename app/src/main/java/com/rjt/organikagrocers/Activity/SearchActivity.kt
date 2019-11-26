package com.rjt.organikagrocers.Activity

import android.content.ClipData
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.rjt.organikagrocers.Class.RxSearchObservable
import com.rjt.organikagrocers.R
import rx.Subscriber
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class SearchActivity : AppCompatActivity() {

    val TAG = SearchActivity::class.java.simpleName
    var searchView: SearchView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)
        searchView = findViewById(R.id.search_view_search)

//        setupSearchObservable()
    }

  /*  private fun setupSearchObservable(){

        RxSearchObservable.fromView(searchView)
            .debounce(300, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .switchMap()
                

    }*/


}
