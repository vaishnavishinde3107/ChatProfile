package com.example.chatprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.security.identity.AccessControlProfile
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var UserArrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//      adding data to each field of the User class
        val name = arrayOf("Mike", "Ashely", "Jenny", "Jack", "Polly")
        val lastMsg = arrayOf("Hi", "Dinner?", "What time you will reach?", "Im going out", "Hey!")
        val lastMsgTime = arrayOf("6:45 PM", "7:55 PM", "9:00 AM", "1:34 PM", "6:00 AM")
        val phoneNo = arrayOf("8874759524", "0863582554", "5383649765", "1249057489", "0945382672")
        val imageId = intArrayOf(
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4
        )
//      initial array List
        UserArrayList = ArrayList()

        for (eachIndex in name.indices) {
            val user = User(
                name[eachIndex],
                lastMsg[eachIndex],
                lastMsgTime[eachIndex],
                phoneNo[eachIndex],
                imageId[eachIndex]
            )

            UserArrayList.add(user)
        }
//      creating adapter
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = MyAdapter(this, UserArrayList)

        listView.setOnItemClickListener { parent, view, position, id ->

            val username = name[position]
            val userPhone = phoneNo[position]
            val userImg = imageId[position]


            val intent = Intent(this, UserPage::class.java)
            intent.putExtra("name", username)
            intent.putExtra("phone", userPhone)
            intent.putExtra("img", userImg)

            startActivity(intent)
        }


    }
}
