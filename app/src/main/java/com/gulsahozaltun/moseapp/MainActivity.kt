package com.gulsahozaltun.moseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController=navHostFragment.navController
        NavigationUI.setupWithNavController(bottomNav, navController)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.signInFragment -> hideBottomNav()
                R.id.signUpFragment -> hideBottomNav()
                else -> showBottomNav()
            }
        }

    }
    fun showBottomNav() {
        bottomNav.visibility = View.VISIBLE

    }

    fun hideBottomNav() {
        bottomNav.visibility = View.GONE

    }
    }
