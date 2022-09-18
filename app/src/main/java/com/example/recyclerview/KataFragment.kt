package com.example.recyclerview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.FragmentKataBinding

class KataFragment : Fragment() {
    private var _binding: FragmentKataBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HurufViewmodel by activityViewModels()

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

        (activity as AppCompatActivity).supportActionBar?.title = "Kata yang dimulai dengan $huruf"

        val dataDaftarKata = resources.getStringArray(R.array.kata).toList().filter { kata -> kata.startsWith(huruf) }

        val adapter = KataAdapter()
        val layoutManager = LinearLayoutManager(requireContext())

        binding.rvKata.adapter = adapter
        binding.rvKata.layoutManager = layoutManager

        adapter.submitData(dataDaftarKata)
        adapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(data: String) {
                openWebPage(data)
            }
        })
    }

    fun openWebPage(kata: String) {
        val url = "https://www.google.com/search?q=$kata"
        val webPage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webPage)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}