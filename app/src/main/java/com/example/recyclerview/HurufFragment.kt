package com.example.recyclerview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.recyclerview.databinding.FragmentHurufBinding
import java.util.*

class HurufFragment : Fragment() {
    private var _binding: FragmentHurufBinding? = null
    private val binding get() = _binding!!

    private lateinit var onDataPass: OnDataPass
    private val viewModel: HurufViewmodel by activityViewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onDataPass = context as OnDataPass
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHurufBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Huruf"
        (activity as MainActivity).hideUpButton()

        klikCari()
    }

    private fun klikCari() {
        binding.tombolCari.setOnClickListener {
            val huruf = binding.etHuruf.text.toString().uppercase(Locale.getDefault())
            if (huruf.isEmpty()) {
                viewModel.getHuruf("")
            } else {
                viewModel.getHuruf(huruf)
            }
            val activity = (activity as MainActivity)
            val destination = KataFragment()
            activity.gotToNextFragment(destination)
        }
    }

//    private fun setRecyclerView() {
//        val dataDaftarHuruf = resources.getStringArray(R.array.huruf)
//        val daftarHuruf = ArrayList<MyContact>()
//
//        for (element in dataDaftarHuruf) {
//            daftarHuruf.add(MyContact(huruf = element))
//        }
//
//        val adapter = HurufAdapter()
//        val layoutManager = LinearLayoutManager(requireContext())
//
////        binding.rvHuruf.adapter = adapter
////        binding.rvHuruf.layoutManager = layoutManager
//
//        adapter.submitData(daftarHuruf)
//
//        adapter.setOnItemClickListener(object : OnItemClickListener{
//            override fun onItemClicked(data: String) {
//                onDataPass.onDataPass(data)
//            }
//        })
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}