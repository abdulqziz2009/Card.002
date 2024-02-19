package com.myself223.card

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.myself223.card.Fragments.SignIn.RegisterFragment
import com.myself223.card.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val navController: NavController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navHostFragment.navController
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
       /* supportActionBar?.hide()
        Handler(Looper.getMainLooper()).postDelayed({
        val intent = Intent(this,RegisterFragment::class.java)
        startActivity(intent)
            finish()


        },3000)*/

        initBottomNav()
        initBottom()
    }



    private fun initBottom(){
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.onBoardFragment) {

                binding.bottomNav.visibility = View.GONE

            } else {

                binding.bottomNav.visibility = View.VISIBLE
            }
            if(destination.id == R.id.categoryFragment) {

                binding.bottomNav.visibility = View.GONE

            } else {

                binding.bottomNav.visibility = View.VISIBLE
            }
            if(destination.id == R.id.addCategoryFragment) {

                binding.bottomNav.visibility = View.GONE

            } else {

                binding.bottomNav.visibility = View.VISIBLE
            }
        }
    }

    private fun initBottomNav() {
        binding.bottomNav.apply {
            setupWithNavController(navController)
            itemIconTintList = null
        }
    }


}
