package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnDataPass{

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hurufFragment = HurufFragment()
        val fragmentManager = supportFragmentManager

        fragmentManager.commit {
            add(R.id.nav_host_fragment_container, hurufFragment)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun gotToNextFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.commit {
            addToBackStack(null)
            replace(R.id.nav_host_fragment_container, fragment)
        }
    }

    override fun onDataPass(huruf: String) {

        val wordFragment = KataFragment()

        val bundle = Bundle()
        bundle.putString("huruf", huruf)

        wordFragment.arguments = bundle
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.nav_host_fragment_container, wordFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    fun showUpButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun hideUpButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    fun clickUpButton() {

        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                return
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    android.R.id.home -> {
                        supportFragmentManager.popBackStack()
                        true
                    }
                    else -> false
                }
            }
        })
    }
}