package com.kodego.inventory.app.arguez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.kodego.inventory.app.arguez.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {


    lateinit var binding: ActivityViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val images = listOf(
            R.drawable.ic_baseline_brush_24,
            R.drawable.ic_baseline_coffee_maker_24,
            R.drawable.ic_baseline_car_repair_24,
            R.drawable.ic_baseline_lock_open_24,
            R.drawable.ic_baseline_person_outline_24,
            R.drawable.fbicon
        )

        val adapter = ViewPagerAdapter(images)
        binding.viewPageView.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPageView){ tab, position ->
            tab.text = "Tab ${position+1}"
        }.attach()
    }
}