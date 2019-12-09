package com.rjt.organikagrocers.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide.init
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        lateinit var auth: FirebaseAuth

        var firstName = text_firstname.text.toString()
        var lastName = text_lastname.text.toString()
        var email = text_email_register.text.toString()
        var password = text_password_register.text.toString()
        var phone = text_phone.text.toString()


        btn_register2.setOnClickListener{

            setupRegister()
        }

        text_view_signin2.setOnClickListener{
             val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setupRegister() {

        var auth = FirebaseAuth.getInstance()
        var firstName = text_firstname.text.toString()
        var lastName = text_lastname.text.toString()
        var email = text_email_register.text.toString()
        var password = text_password_register.text.toString()
        var phone = text_phone.text.toString()


        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(
                OnCompleteListener<AuthResult> {

                    if (it.isSuccessful) {

                        Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, LoginActivity::class.java)

                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
    }

