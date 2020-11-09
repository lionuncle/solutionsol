package com.lionuncle.solutionsol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.FirebaseApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text1 = findViewById<TextView>(R.id.TextView1)
        val text2 = findViewById<TextView>(R.id.TextView2)
        val text3 = findViewById<TextView>(R.id.TextView3)
        val text4 = findViewById<TextView>(R.id.TextView4)
        val text5 = findViewById<TextView>(R.id.TextView5)
        val text6 = findViewById<TextView>(R.id.TextView6)
        val text7 = findViewById<TextView>(R.id.TextView7)
        FirebaseApp.initializeApp(this);
        val repo = Repository()
        text1.setOnClickListener {
            repo.addNewItem(text1.text.toString(),this)
        }
        text2.setOnClickListener {
            repo.addNewItem(text2.text.toString(),this)
        }
        text3.setOnClickListener {
            repo.addNewItem(text3.text.toString(),this)
        }
        text4.setOnClickListener {
            repo.addNewItem(text4.text.toString(),this)
        }
        text5.setOnClickListener {
            repo.addNewItem(text5.text.toString(),this)
        }
        text6.setOnClickListener {
            repo.addNewItem(text6.text.toString(),this)
        }
        text7.setOnClickListener {
            repo.addNewItem(text7.text.toString(),this)
        }

        val cart = findViewById<FloatingActionButton>(R.id.cart)
        cart.setOnClickListener {
            Toast.makeText(this,"There are "+repo.getNumber(this).toString() + " Items",Toast.LENGTH_SHORT).show()
        }



    }
}