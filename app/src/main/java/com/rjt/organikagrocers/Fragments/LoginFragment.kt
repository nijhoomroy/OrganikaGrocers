package com.rjt.organikagrocers.Fragments


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.rjt.organikagrocers.Activity.MainActivity

import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import java.util.regex.Pattern

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_login, container, false)

        var myPref: SharedPreferences? =
            activity?.getSharedPreferences("demo", Context.MODE_PRIVATE)

        var email = myPref?.getString("Email", null)
        var password = myPref?.getString("Password", null)

        view.edit_text_email_login.setText(email)
        view.edit_text_password_login.setText(password)

        view.btn_login.setOnClickListener {

            var email = view.edit_text_email_login.text.toString()
            var password = view.edit_text_password_login.text.toString()

            var emailPattern: Pattern = Patterns.EMAIL_ADDRESS

            if (emailPattern.matcher(email).matches() && password.length >= 6) {
                if (email != null) {
                    var intent: Intent = Intent(activity?.application, MainActivity::class.java)
                    startActivity(intent)
                }
            } 
            else {
                Toast.makeText(activity, "Please enter a valid email", Toast.LENGTH_LONG).show()

            }


        }

        val signup_clickme = view.findViewById(R.id.text_view_signup) as TextView

        signup_clickme.setOnClickListener{
            
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_loginregister_container, RegisterFragment())?.commit()
        }
        return view

    }
}