package com.rjt.organikagrocers.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.rjt.organikagrocers.Class.SessionManager
import com.rjt.organikagrocers.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.requestFeature(Window.FEATURE_NO_TITLE)
        //making this activity full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.splash_screen)

        //5second splash time
        Handler().postDelayed({
            if (SessionManager().getLoggedStatus(this@SplashScreenActivity)){

                val intent: Intent = Intent(this@SplashScreenActivity, HomeActivity::class.java)
                startActivity(intent)
            } else{

                startActivity(Intent(this@SplashScreenActivity, LoginRegister::class.java))

            }
            //start main activity

            //finish this activity
            finish()
        },2000)

    }
    }


