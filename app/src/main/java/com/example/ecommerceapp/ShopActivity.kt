package com.example.ecommerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)


        val email = intent.getStringExtra("username")
        val welcomeMessage = "Welcome, $email!"


        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
        welcomeTextView.text = welcomeMessage



        val kitchenImageView = findViewById<ImageView>(R.id.aa)
        val toysImageView = findViewById<ImageView>(R.id.a)
        val makeupImageView = findViewById<ImageView>(R.id.cc)
        val feedingImageView = findViewById<ImageView>(R.id.c)


        kitchenImageView.setOnClickListener(View.OnClickListener {
            val message = "You have chosen the home and Kitchen category of shopping"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })
        toysImageView.setOnClickListener(View.OnClickListener {
            val message = "You have chosen the Toys and games category of shopping"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })

        feedingImageView.setOnClickListener(View.OnClickListener {
            val message = "You have chosen the Pets supplies category of shopping"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })

        makeupImageView.setOnClickListener(View.OnClickListener {
            val message = "You have chosen the Beauty category of shopping"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })
    }
}