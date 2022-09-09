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
            MyContact("A"),
            MyContact("B"),
            MyContact("C"),
            MyContact("D"),
            MyContact("E"),
            MyContact("F"),
            MyContact("G"),
            MyContact("H"),
            MyContact("I"),
            MyContact("J"),
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