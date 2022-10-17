package com.kodego.inventory.app.arguez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodego.inventory.app.arguez.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var name = intent.getStringExtra("nameID")

        binding.tvWelcome.text = "Welcome $name"
    }
}