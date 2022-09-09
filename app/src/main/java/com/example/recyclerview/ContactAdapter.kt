package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter (private val listContact: ArrayList<MyContact>)
    : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    // class holder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nama: TextView = itemView.findViewById(R.id.tvNama)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_contact_item, parent, false)
        return ViewHolder(view)
    }

    // melakukan penentuan data yg akan ditampilkan pada tiap baris
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nama.text = listContact[position].huruf
    }

    override fun getItemCount(): Int {
        return listContact.size
    }
}