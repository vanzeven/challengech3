package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.MyContactItemBinding

class KataAdapter : RecyclerView.Adapter<KataAdapter.ViewHolder>(){

    private lateinit var onItemClickListener: OnItemClickListener

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }

    // class holder
    class ViewHolder(val binding: MyContactItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val daftarKata = ArrayList<String>()

    fun submitData(list: List<String>) {
        daftarKata.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = MyContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    // melakukan penentuan data yg akan ditampilkan pada tiap baris
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val kata = daftarKata[position]

        with(holder) {
            binding.tombol.text = kata
            binding.tombol.setOnClickListener {
                onItemClickListener.onItemClicked(kata)
            }
        }
    }

    override fun getItemCount(): Int = daftarKata.size
}