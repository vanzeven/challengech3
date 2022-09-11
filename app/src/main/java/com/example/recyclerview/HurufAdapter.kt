package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.MyContactItemBinding

class HurufAdapter : RecyclerView.Adapter<HurufAdapter.ViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }

    // class holder
    class ViewHolder(val binding: MyContactItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<MyContact>() {
        override fun areItemsTheSame(oldItem: MyContact, newItem: MyContact): Boolean {
            return oldItem.huruf == newItem.huruf
        }

        override fun areContentsTheSame(oldItem: MyContact, newItem: MyContact): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitData(list: ArrayList<MyContact>) {
        differ.submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = MyContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    // melakukan penentuan data yg akan ditampilkan pada tiap baris
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(differ.currentList[position]) {
                binding.tombol.text = huruf
                binding.tombol.setOnClickListener {
                    onItemClickListener.onItemClicked(binding.tombol.text.toString())
                }
            }
        }
    }

    override fun getItemCount(): Int = differ.currentList.size
}