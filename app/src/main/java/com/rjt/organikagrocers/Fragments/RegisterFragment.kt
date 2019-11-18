package com.rjt.organikagrocers.Fragments


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.fragment_register.view.*

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_register, container, false)

        view.btn_register.setOnClickListener{

            var email = view.edit_text_email_register.text.toString()
            var password = view.edit_text_password_register.text.toString()

            var myPrefEmail : SharedPreferences? = activity?.getSharedPreferences("demo", Context.MODE_PRIVATE)

            var editor = myPrefEmail?.edit()

            editor?.putString("Email", email)
            editor?.putString("Password", password)

            editor?.commit()

            fragmentManager?.beginTransaction()?.replace(R.id.fragment_loginregister_container, LoginFragment())?.commit()

        
    }
        return view


}
}
