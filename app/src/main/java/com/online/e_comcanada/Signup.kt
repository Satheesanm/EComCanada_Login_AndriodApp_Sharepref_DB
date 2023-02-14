package com.online.e_comcanada

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class Signup : AppCompatActivity() {

    lateinit var edit_fname : EditText
    lateinit var edit_lname : EditText
    lateinit var edit_email : EditText
    lateinit var edit_pass : EditText
    lateinit var edit_pass_confo : EditText
    lateinit var btn_Signup : ImageButton
    lateinit var alreadysignInLink : TextView


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val sharedPref = getSharedPreferences("myPrefe", MODE_PRIVATE)
        edit_fname=findViewById(R.id.editTextFirstName)
        edit_lname=findViewById(R.id.editTextLastName)
        edit_email=findViewById(R.id.editTextEmailAddress)
        edit_pass=findViewById(R.id.editTextPassword)
        btn_Signup=findViewById(R.id.registerBtn)
        edit_pass_confo=findViewById(R.id.editTextCofirmPassword)
        alreadysignInLink=findViewById(R.id.alreadysignInLink)

        btn_Signup.setOnClickListener {
        val editor = sharedPref.edit()
            if(!edit_pass.text.toString().equals(edit_pass_confo.text.toString())){
                Toast.makeText(this@Signup, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else if(
                TextUtils.isEmpty(edit_fname.text.toString())||
                TextUtils.isEmpty(edit_lname.text.toString())||
                TextUtils.isEmpty(edit_email.text.toString())||
                TextUtils.isEmpty(edit_pass.text.toString())||
                TextUtils.isEmpty(edit_pass_confo.text.toString()))
            { Toast.makeText(this@Signup, "Passwords do not match", Toast.LENGTH_SHORT).show()}

            else{
                editor.apply{
                    putString("fname", edit_fname.text.toString())
                    putString("lname", edit_lname.text.toString())
                    putString("email", edit_email.text.toString())
                    putString("pass", edit_pass.text.toString())
                    apply()
                    Toast.makeText(this@Signup, "Signup Successful", Toast.LENGTH_SHORT).show()
                }
                    startActivity(Intent(this@Signup, MainActivity::class.java))
            }
        }
        alreadysignInLink.setOnClickListener {
            startActivity(Intent(this@Signup, Login::class.java))
        }

    }
}