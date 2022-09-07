package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listContact = arrayListOf(
            MyContact("Sabrina", "0812696969"),
            MyContact("Adi", "0812177013"),
            MyContact("Budi", "0812215600"),
            MyContact("Sabrinab", "0812696969"),
            MyContact("Adib", "0812177013"),
            MyContact("Budib", "0812215600"),
            MyContact("Sabrinac", "0812696969"),
            MyContact("Adic", "0812177013"),
            MyContact("Budic", "0812215600"),
            MyContact("Sabrinad", "0812696969"),
            MyContact("Adid", "0812177013"),
            MyContact("Budid", "0812215600"),
        )

        // membuat adapter
        val adapter = ContactAdapter(listContact)

        // membuat layout manager
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // membuat recyclerview
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // set LayoutManager pada RecyclervView
        recyclerView.layoutManager = layoutManager

        // set Adapter pada RecyclerView
        recyclerView.adapter = adapter
    }
}