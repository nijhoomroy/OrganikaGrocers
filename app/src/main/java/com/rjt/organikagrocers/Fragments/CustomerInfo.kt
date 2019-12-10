package com.rjt.organikagrocers.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.fragment_customer_info.*

/**
 * A simple [Fragment] subclass.
 */
class CustomerInfo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_customer_info, container, false)



        return view
    }



}
