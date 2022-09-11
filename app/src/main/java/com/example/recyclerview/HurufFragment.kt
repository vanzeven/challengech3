package com.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.FragmentHurufBinding

class HurufFragment : Fragment() {
    private var _binding: FragmentHurufBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHurufBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
    }

    private fun setRecyclerView() {
        val dataDaftarHuruf = resources.getStringArray(R.array.huruf)
        val daftarHuruf = ArrayList<MyContact>()

        for (element in dataDaftarHuruf) {
            daftarHuruf.add(MyContact(huruf = element))
        }

        val adapter = HurufAdapter()
        val layoutManager = LinearLayoutManager(requireContext())

        binding.rvHuruf.adapter = adapter
        binding.rvHuruf.layoutManager = layoutManager

        adapter.submitData(daftarHuruf)

        adapter.setOnItemClickListener(object : OnItemClickListener{
            override fun onItemClicked(data: String) {
                val action = HurufFragmentDirections.actionHurufToKata(data)
                findNavController().navigate(directions = action)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}