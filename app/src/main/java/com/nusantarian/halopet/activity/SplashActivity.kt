package com.nusantarian.halopet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nusantarian.halopet.R
import com.nusantarian.halopet.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        checkSession()
    }

    private fun checkSession(){

    }
}