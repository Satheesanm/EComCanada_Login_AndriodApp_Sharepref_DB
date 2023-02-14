package com.online.e_comcanada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class UserInfo : AppCompatActivity() {


    lateinit var edit_fname : TextView
    lateinit var edit_lname : TextView
    lateinit var edit_email : TextView
    lateinit var btn_logout : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        edit_fname = findViewById(R.id.editIuserInfoTextFirstName)
        edit_lname = findViewById(R.id.editIuserInfoTextLastName)
        edit_email = findViewById(R.id.editIuserInfoTextEmail)
        btn_logout = findViewById(R.id.logout)

        val sharedPref = getSharedPreferences("myPrefe", MODE_PRIVATE)

        val email= intent.extras!!.getString("email").toString()
        edit_email.text = email

        try {
            edit_fname.text=sharedPref.getString("fname", null).toString()
            edit_lname.text=sharedPref.getString("lname", null).toString()
        } catch (e: Exception) {
            Toast.makeText(this@UserInfo, "Something went wrong", Toast.LENGTH_SHORT).show()
        }
        btn_logout.setOnClickListener {
            startActivity(Intent(this@UserInfo, Login::class.java))
        }

    }
    }
