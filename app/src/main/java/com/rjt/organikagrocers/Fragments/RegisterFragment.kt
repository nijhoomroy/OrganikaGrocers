package com.rjt.organikagrocers.Fragments


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
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
import com.rjt.organikagrocers.Models.RegisterModel

import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.activity_login_register.*
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_register, fragment_loginregister_container, false)

        setupRegister()

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

        val signin_clickme = view.findViewById(R.id.text_view_signin) as TextView

        signin_clickme.setOnClickListener{

            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_loginregister_container, LoginFragment())?.commit()
        }

        return view


}

    private fun setupRegister() {
        var firstname = view?.edit_text_firstname?.text.toString()
        var lastname = view?.edit_text_lastname?.text.toString()
        var email_register = view?.edit_text_email_register?.text.toString()
        var password_register = view?.edit_text_password_register?.text.toString()
        var phone = view?.edit_text_phone?.text.toString()

        val url: String = "https://apolis-grocery.herokuapp.com/api/auth/register"
        var requestQueue = Volley.newRequestQueue(this.activity)
        var register: RegisterModel = RegisterModel(firstname, lastname, email_register, password_register, phone)


        val json = Gson().toJson(register)

        val jsonObjReq = JsonObjectRequest(Request.Method.POST, url, JSONObject(json),
            Response.Listener { Log.e("test", "success!")

                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fragment_loginregister_container, LoginFragment())?.commit()

                Toast.makeText(activity, "Registered Successfully", Toast.LENGTH_LONG).show()
            },

            Response.ErrorListener {
//                Toast.makeText(activity, "Registered Successfully", Toast.LENGTH_LONG).show()
            })

        requestQueue.add(jsonObjReq)



    }
}
