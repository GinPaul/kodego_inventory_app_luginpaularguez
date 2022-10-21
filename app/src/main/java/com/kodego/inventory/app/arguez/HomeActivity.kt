package com.kodego.inventory.app.arguez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodego.inventory.app.arguez.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //data source
        var productList = mutableListOf<Products>(
            Products(R.drawable.coffeemaker, "Coffee Maker", "This is a coffee maker."),
            Products(R.drawable.paintbrush, "Paint Brush", "This is a premium paint brush."),
            Products(R.drawable.toyotagenuineparts, "Cart Parts", "This is a bundle for car parts."),
            Products(R.drawable.ic_baseline_coffee_maker_24, "Coffee Maker", "This is a coffee maker."),
            Products(R.drawable.ic_baseline_brush_24, "Paint Brush", "This is a premium paint brush."),
            Products(R.drawable.ic_baseline_car_repair_24, "Cart Parts", "This is a bundle for car parts."),
            Products(R.drawable.ic_baseline_coffee_maker_24, "Coffee Maker", "This is a coffee maker."),
            Products(R.drawable.ic_baseline_brush_24, "Paint Brush", "This is a premium paint brush."),
            Products(R.drawable.ic_baseline_car_repair_24, "Cart Parts", "This is a bundle for car parts."),
            Products(R.drawable.ic_baseline_coffee_maker_24, "Coffee Maker", "This is a coffee maker."),
            Products(R.drawable.ic_baseline_brush_24, "Paint Brush", "This is a premium paint brush."),
            Products(R.drawable.ic_baseline_car_repair_24, "Cart Parts", "This is a bundle for car parts."),
            Products(R.drawable.ic_baseline_coffee_maker_24, "Coffee Maker", "This is a coffee maker."),
            Products(R.drawable.ic_baseline_brush_24, "Paint Brush", "This is a premium paint brush."),
            Products(R.drawable.ic_baseline_car_repair_24, "Cart Parts", "This is a bundle for car parts."),
            Products(R.drawable.ic_baseline_coffee_maker_24, "Coffee Maker", "This is a coffee maker."),
            Products(R.drawable.ic_baseline_brush_24, "Paint Brush", "This is a premium paint brush."),
            Products(R.drawable.ic_baseline_car_repair_24, "Cart Parts", "This is a bundle for car parts."),
            Products(R.drawable.ic_baseline_car_repair_24, "Cart Parts", "This is a bundle for car parts."),
            Products(R.drawable.ic_baseline_coffee_maker_24, "Coffee Maker", "This is a coffee maker."),
            Products(R.drawable.ic_baseline_brush_24, "Paint Brush", "This is a premium paint brush."),
            Products(R.drawable.ic_baseline_car_repair_24, "Cart Parts", "This is a bundle for car parts."),
            Products(R.drawable.ic_baseline_coffee_maker_24, "Coffee Maker", "This is a coffee maker."),
            Products(R.drawable.ic_baseline_brush_24, "Paint Brush", "This is a premium paint brush."),
            Products(R.drawable.ic_baseline_car_repair_24, "Cart Parts", "This is a bundle for car parts."),
            Products(R.drawable.ic_baseline_coffee_maker_24, "Coffee Maker", "This is a coffee maker."),
            Products(R.drawable.ic_baseline_brush_24, "Paint Brush", "This is a premium paint brush."),
            Products(R.drawable.ic_baseline_car_repair_24, "Cart Parts", "This is a bundle for car parts.")

        )

        //pass data source to adapter
        val adapter = ProductAdapter(productList)
        adapter.onItemClick = {
            Toast.makeText(applicationContext,it.itemName, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("itemName", it.itemName)
            intent.putExtra("itemDescription", it.itemDescription)
            intent.putExtra("itemImage", it.imageName)
            startActivity(intent) //>>don't place "finish" so that yo can go back the product list
        }

        binding.myRecycler.adapter = adapter
        binding.myRecycler.layoutManager = LinearLayoutManager(this)

                //get data from another screen
//        var name = intent.getStringExtra("nameID")
//
//        binding.tvWelcome.text = "Welcome $name"
    }
}