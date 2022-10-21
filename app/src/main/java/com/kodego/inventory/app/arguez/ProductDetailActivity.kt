package com.kodego.inventory.app.arguez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodego.inventory.app.arguez.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //data from home activity
        var itemName: String? = intent.getStringExtra("itemName") //>>need to add "?" to accept null inputs/values
        var itemDescription : String? = intent.getStringExtra("itemDescription")
        var imageItem: Int = intent.getIntExtra("itemImage",0)

        binding.imgItem2.setImageResource(imageItem)
        binding.txtItemName2.text = itemName
        binding.txtDescription2.text = itemDescription
    }
}