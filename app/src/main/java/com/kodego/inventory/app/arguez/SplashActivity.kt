package com.kodego.inventory.app.arguez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_inventoryapp)

        CoroutineScope(Dispatchers.Main).launch {
            delay(3500L)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }

}