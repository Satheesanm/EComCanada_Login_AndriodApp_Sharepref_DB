package com.online.e_comcanada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Login : AppCompatActivity() {

    lateinit var edit_email:EditText
    lateinit var edit_password:EditText
    lateinit var btn_loginscreen: ImageButton
    lateinit var linkNewReq: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edit_email = findViewById(R.id.editLoginEmailAddress)
        edit_password = findViewById(R.id.editLoginTextPassword)
        btn_loginscreen = findViewById(R.id.loginImage)
        linkNewReq = findViewById(R.id.registerlink)

        val sharedPref = getSharedPreferences("myPrefe", MODE_PRIVATE)

        btn_loginscreen.setOnClickListener {
            try {
                val email = sharedPref.getString("email", null).toString()
                val pass = sharedPref.getString("pass", null).toString()
                if (email.equals(edit_email.text.toString()) && pass.equals(edit_password.text.toString())) {
                    Toast.makeText(this@Login, "Login Successful", Toast.LENGTH_SHORT).show()
                    val i = Intent(this@Login, UserInfo::class.java)
                    i.putExtra("email", edit_email.text.toString())
                    startActivity(i);
                } else {
                    Toast.makeText(this@Login, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@Login, "No Records Found", Toast.LENGTH_SHORT).show()
            }
        }

        linkNewReq.setOnClickListener {
            startActivity(Intent(this@Login, Signup::class.java))
        }

    }
}