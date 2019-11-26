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
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.rjt.organikagrocers.Activity.HomeActivity
import com.rjt.organikagrocers.Class.SessionManager
import com.rjt.organikagrocers.Models.LoginModel

import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.fragment_login.view.*
import org.json.JSONObject
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

        if (SessionManager().getLoggedStatus(this.activity!!)){

            val intent: Intent = Intent(activity, HomeActivity::class.java)
            startActivity(intent)
        } else {
            view.login_page.visibility = View.VISIBLE}



        getRegisterPref()

        view.btn_login.setOnClickListener {

            var email = view.edit_text_email_login.text.toString()
            var password = view.edit_text_password_login.text.toString()

            var emailPattern: Pattern = Patterns.EMAIL_ADDRESS

            if (emailPattern.matcher(email).matches()) {
                if (email != null) {
                    var intent: Intent = Intent(activity?.application, HomeActivity::class.java)
                    startActivity(intent)
                }
            } else {
                Toast.makeText(activity, "Please enter a valid email", Toast.LENGTH_LONG).show()

            }


            val signup_clickme = view.findViewById(R.id.text_view_signup) as TextView

            signup_clickme.setOnClickListener {

                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fragment_loginregister_container, RegisterFragment())?.commit()
            }

            setupLogin()

        }
        return view
    }

    private fun getRegisterPref() {
        var myPref: SharedPreferences? =
            activity?.getSharedPreferences("demo", Context.MODE_PRIVATE)

        var email = myPref?.getString("Email", null)
        var password = myPref?.getString("Password", null)

        view?.edit_text_email_login?.setText(email)
        view?.edit_text_password_login?.setText(password)

    }

    private fun setupLogin(){

        var email: String = view?.edit_text_email_login?.text.toString()
        var password: String = view?.edit_text_password_login?.text.toString()

        val url: String = "https://apolis-grocery.herokuapp.com/api/auth/login"
        val requestQueue = Volley.newRequestQueue(this.activity)
        var login_send = LoginModel(email, password)

        var json = Gson().toJson(login_send)

        var jsonObgReq : JsonObjectRequest = JsonObjectRequest(Request.Method.POST, url, JSONObject(json),
            Response.Listener {
                SessionManager().setLoggedIn(this.activity!!, true)

            },
            Response.ErrorListener { Toast.makeText(activity, "Account not found", Toast.LENGTH_LONG).show() })

        requestQueue.add(jsonObgReq)




    }
}

