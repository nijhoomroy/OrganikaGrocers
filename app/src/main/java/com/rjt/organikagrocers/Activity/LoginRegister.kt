package com.rjt.organikagrocers.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rjt.organikagrocers.Fragments.LoginFragment
import com.rjt.organikagrocers.Fragments.RegisterFragment
import com.rjt.organikagrocers.R

class LoginRegister : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)

        supportFragmentManager.beginTransaction().add(R.id.fragment_loginregister_container, LoginFragment()).commit()
        
    }
}
