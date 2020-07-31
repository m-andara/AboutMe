package com.example.aboutme

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemSelectedListener{
            handleBottomNavigation(it.itemId, binding)
        }
        binding.bottomNavigation.selectedItemId = R.id.menu_bio
        binding.bottomNavigation.setBackgroundColor(ContextCompat.getColor(this, R.color.pink))
    }

    private fun handleBottomNavigation(menuItemId: Int, binding: ActivityMainBinding): Boolean =
        when(menuItemId) {
            R.id.menu_bio -> {
                binding.bottomNavigation.setBackgroundColor(ContextCompat.getColor(this, R.color.pink))
                swapFragments(BioFragment())
                true
            }
            R.id.menu_family -> {
                binding.bottomNavigation.setBackgroundColor(ContextCompat.getColor(this, R.color.light_blue))
                swapFragments(FamilyFragment())
                true
            }
            R.id.menu_hobbies -> {
                binding.bottomNavigation.setBackgroundColor(ContextCompat.getColor(this, R.color.light_green))
                swapFragments(HobbiesFragment())
                true
            }
            else -> false
        }

    private fun swapFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}