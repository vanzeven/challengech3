package com.example.recyclerview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.FragmentKataBinding

class KataFragment : Fragment() {
    private var _binding: FragmentKataBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentKataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).showUpButton()
        (activity as MainActivity).clickUpButton()

        val huruf = arguments?.getString("huruf")!!

        (activity as AppCompatActivity).supportActionBar?.title = "Kata yang dimulai dengan $huruf"

        val daftarKata = resources.getStringArray(R.array.kata).toList().filter { kata -> kata.startsWith(huruf) }

        val adapter = KataAdapter()
        val layoutManager = LinearLayoutManager(requireContext())

        binding.rvKata.adapter = adapter
        binding.rvKata.layoutManager = layoutManager

        adapter.submitData(daftarKata)
        adapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(data: String) {
                openWebPage(data)
            }
        })
    }

    fun openWebPage(word: String) {
        val url = "https://www.google.com/search?q=$word"
        val webPage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webPage)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}