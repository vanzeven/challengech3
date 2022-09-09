package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter (private val listContact: ArrayList<MyContact>)
    : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    // class holder
    class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val nama: TextView = itemView.findViewById(R.id.tvNama)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_contact_item, parent, false)
        return ViewHolder(view, mListener)
    }

    // melakukan penentuan data yg akan ditampilkan pada tiap baris
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nama.text = listContact[position].huruf
    }

    override fun getItemCount(): Int {
        return listContact.size
    }
}