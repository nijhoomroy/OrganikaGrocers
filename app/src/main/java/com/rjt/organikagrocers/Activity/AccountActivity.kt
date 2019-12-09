package com.rjt.organikagrocers.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.activity_account.*


class AccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)




        logout()
    }

    private fun logout() {

        btn_logout.setOnClickListener{
            var auth = FirebaseAuth.getInstance()
            var user = FirebaseAuth.getInstance().currentUser as FirebaseUser

            AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id -> auth.signOut()

                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent) }
                .setNegativeButton("No", null)
                .show()

        }

    }


}
