package com.example.ecommerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val usersList = ArrayList<User>()
    fun onForgotPasswordClick(view: View) {
        val usernameEditText = findViewById<EditText>(R.id.emailEditText)
        val usernameOrEmail = usernameEditText.text.toString()

        val foundUser = usersList.find { it.emailOrPhone == usernameOrEmail || it.password == usernameOrEmail }

        if (foundUser != null) {
            val password = foundUser.password

            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "text/plain"
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Your password: $password")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Password Recovery")

            if (emailIntent.resolveActivity(packageManager) != null) {
                startActivity(emailIntent)
            } else {
                Toast.makeText(this, "No email found", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "User not found. Please enter a valid username or email.", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usersList.add(User("Kidus", "kidus@kidus.com", "kidus", ))


        val usernameEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)




        loginButton.setOnClickListener(View.OnClickListener {
            val enteredUsername = usernameEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()

            val userFound = usersList.find { it.emailOrPhone == enteredUsername && it.password == enteredPassword }

            if (userFound != null) {
                val message = "Login successful. Welcome, ${userFound.fullName}!"

                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

                val intent = Intent(this, ShopActivity::class.java)
                intent.putExtra("username", userFound.fullName)
                startActivity(intent)
            } else {
                val message = "Login failed. Invalid username or password."
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun goToSignUpActivity(view: View) {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }
}