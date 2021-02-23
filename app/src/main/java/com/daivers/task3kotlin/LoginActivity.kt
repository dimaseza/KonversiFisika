package com.daivers.task3kotlin

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    val MIN_PASSWORD_LENGTH = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            if (validateInput()) {
                if (username == "udacodingid" && password == "udacodingJaya2021") {
                    val progressDialog = ProgressDialog(this, R.style.Theme_MaterialComponents_Light_Dialog)
                    progressDialog.isIndeterminate = true
                    progressDialog.setMessage("Loading...")
                    progressDialog.show()
                    val intent = Intent(this, FisikaActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Username and Password wrong", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun validateInput(): Boolean {
        if (etUsername.text.isEmpty() && etPassword.text.isEmpty()) {
            Toast.makeText(this, "Please fill the field", Toast.LENGTH_SHORT).show()
            return false
        }
        if (etPassword.text.length < MIN_PASSWORD_LENGTH) {
            Toast.makeText(this, "Password length mush be more than " + MIN_PASSWORD_LENGTH, Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}