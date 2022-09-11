package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val letterFragment = KataFragment()
        val fragmentManager = supportFragmentManager

        fragmentManager.commit {
            add(R.id.nav_host_fragment_container, letterFragment)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun onDataPass(letter: String) {

        val wordFragment = KataFragment()

        val bundle = Bundle()
        bundle.putString("letter", letter)

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