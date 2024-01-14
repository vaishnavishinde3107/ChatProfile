package com.example.chatprofile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_page)

        val username = intent.getStringExtra("name")
        val userPhone = intent.getStringExtra("phone")
        val userImg = intent.getIntExtra("img", R.drawable.img)

        val name = findViewById<TextView>(R.id.username)
        val phoneNo = findViewById<TextView>(R.id.phone)
        val imgId = findViewById<CircleImageView>(R.id.profile_image)

        name.text = username
        phoneNo.text = userPhone
        imgId.setImageResource(userImg)

        val callButton = findViewById<Button>(R.id.callBtn)

        callButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$userPhone")
            startActivity(intent)
        }
    }
}