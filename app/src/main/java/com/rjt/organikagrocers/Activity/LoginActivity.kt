package com.rjt.organikagrocers.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide.init
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        lateinit var auth: FirebaseAuth
        lateinit var user : FirebaseUser

        var email = text_email_login.text.toString()
        var password = text_password_login.text.toString()


      btn_login2.setOnClickListener {
          if (email == null && password == null) {

              if(email == null || password == null) {
                  Toast.makeText(this, "Please enter valid credentials", Toast.LENGTH_SHORT).show()

              }
          }
          else {

              progress_bar.visibility = View.VISIBLE
              setupLogin()
          }
      }

        text_view_forgotpassword.setOnClickListener{

            if (email == null){
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            }

            else {forgotPassword() }
        }


        text_view_signup2.setOnClickListener{

            val intent = Intent(this, RegisterActivity::class.java)

            startActivity(intent)
        }



        }

    private fun forgotPassword() {
        var auth = FirebaseAuth.getInstance()
        var email = text_email_login.text.toString()

        auth.sendPasswordResetEmail(email).addOnCompleteListener(
            OnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this, "Password reset information sent", Toast.LENGTH_SHORT).show()
                }

                else {
                    Toast.makeText(this, "Account not found. Please try again.", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }


    private fun setupLogin() {

        var auth = FirebaseAuth.getInstance()
        var email = text_email_login.text.toString()
        var password = text_password_login.text.toString()

            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(
                OnCompleteListener<AuthResult> {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT)
                            .show()

                        var intent: Intent = Intent(this, HomeActivity::class.java)

                        startActivity(intent)

                    } else {
                        Toast.makeText(
                            this,
                            "Account not found. Please try again.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }


                }
            )

    }

    }
