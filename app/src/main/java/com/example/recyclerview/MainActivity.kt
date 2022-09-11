package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val listContact = arrayListOf(
        MyContact("A", arrayListOf("Acropolis")),
        MyContact("B", arrayListOf("Batey")),
        MyContact("C", arrayListOf("Carolean")),
        MyContact("D", arrayListOf("De Zeven Provincien")),
        MyContact("E", arrayListOf("Eiffel Tower")),
        MyContact("F", arrayListOf("Feitoria")),
        MyContact("G", arrayListOf("Gaesatae")),
        MyContact("H", arrayListOf("Heitaroi")),
        MyContact("I", arrayListOf("Ikanda")),
        MyContact("J", arrayListOf("Jaguar Warrior")),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Words"

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
        adapter.setOnItemClickListener(object : ContactAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity, "you clicked on item no $position", Toast.LENGTH_SHORT).show()
            }
        })
    }
}