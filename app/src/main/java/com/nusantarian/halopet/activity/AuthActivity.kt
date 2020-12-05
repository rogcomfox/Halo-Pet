package com.nusantarian.halopet.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.nusantarian.halopet.R
import com.nusantarian.halopet.databinding.ActivityAuthBinding
import com.nusantarian.halopet.fragment.LandingFragment

class AuthActivity : AppCompatActivity(), FragmentManager.OnBackStackChangedListener {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.addOnBackStackChangedListener(this)
        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction().add(R.id.frame_auth, LandingFragment())
            .commit()
    }

    override fun onBackStackChanged() {
        TODO("Not yet implemented")
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0)
            supportFragmentManager.popBackStack()
        else
            super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        supportFragmentManager.popBackStack()
        return true
    }
}