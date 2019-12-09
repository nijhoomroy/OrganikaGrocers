package com.rjt.organikagrocers.Notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.rjt.organikagrocers.Activity.HomeActivity
import com.rjt.organikagrocers.R
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {

    private val CHANNEL_ID: String = "coupon_info"
    private val NOTIFICATION_ID: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        init()
    }

    private fun init(){
        btn_clickme_notification.setOnClickListener{
            displayNotification()

        }
    }


    private fun createNotification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            var name = "$50 credit info"
            var description = "Include the user about how to receive the credit"
            var importance = NotificationManager.IMPORTANCE_DEFAULT

            var notificationChannel = NotificationChannel(CHANNEL_ID, name, importance)

            notificationChannel.description = description

            var notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)

        }
    }

    private fun displayNotification(){
        var builder: NotificationCompat.Builder = NotificationCompat.Builder(this, CHANNEL_ID)
        builder.setSmallIcon(R.drawable.ic_question_answer_black_24dp)
        builder.setContentTitle("Get $50!")
        builder.setContentText("Get $50 credit when you invite your friend to shop on Organika Grocers")
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }
}


