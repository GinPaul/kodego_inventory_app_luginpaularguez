package com.kodego.inventory.app.arguez

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodego.inventory.app.arguez.databinding.ActivityHomeBinding
import com.kodego.inventory.app.arguez.databinding.AddDialogBinding
import com.kodego.inventory.app.arguez.databinding.QuantityDialogBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var adapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //data source
        var productList: MutableList<Products> = mutableListOf<Products>(
            Products(R.drawable.coffeemaker, "Coffee Maker", "This is a coffee maker.", 10),
            Products(R.drawable.paintbrush, "Paint Brush", "This is a premium paint brush.", 50),
            Products(
                R.drawable.toyotagenuineparts,
                "Cart Parts",
                "This is a bundle for car parts.",
                20
            ),
            Products(
                R.drawable.ic_baseline_coffee_maker_24,
                "Coffee Maker",
                "This is a coffee maker.",
                0
            ),
            Products(
                R.drawable.ic_baseline_brush_24,
                "Paint Brush",
                "This is a premium paint brush.",
                0
            ),
            Products(
                R.drawable.ic_baseline_car_repair_24,
                "Cart Parts",
                "This is a bundle for car parts.",
                0
            ),
            Products(
                R.drawable.ic_baseline_coffee_maker_24,
                "Coffee Maker",
                "This is a coffee maker.",
                0
            ),
            Products(R.drawable.coffeemaker, "Coffee Maker", "This is a coffee maker.", 10),
            Products(R.drawable.paintbrush, "Paint Brush", "This is a premium paint brush.", 50),
            Products(
                R.drawable.toyotagenuineparts,
                "Cart Parts",
                "This is a bundle for car parts.",
                20
            ),
            Products(
                R.drawable.ic_baseline_coffee_maker_24,
                "Coffee Maker",
                "This is a coffee maker.",
                0
            ),
            Products(
                R.drawable.ic_baseline_brush_24,
                "Paint Brush",
                "This is a premium paint brush.",
                0
            ),
            Products(
                R.drawable.ic_baseline_car_repair_24,
                "Cart Parts",
                "This is a bundle for car parts.",
                0
            ),
            Products(
                R.drawable.ic_baseline_coffee_maker_24,
                "Coffee Maker",
                "This is a coffee maker.",
                0
            )

        )

        //pass data source to adapter
        adapter = ProductAdapter(productList)
        adapter.onItemClick = {
            Toast.makeText(applicationContext, it.itemName, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("itemName", it.itemName)
            intent.putExtra("itemDescription", it.itemDescription)
            intent.putExtra("itemImage", it.imageName)
            intent.putExtra("quantity", it.quantity)
            startActivity(intent) //>>don't place "finish" so that the can go back the product list
        }

        adapter.onUpdateButtonClick = { item: Products, position: Int ->
            showUpdateDialog(item, position)
//            Toast.makeText(applicationContext, "Quantity update.", Toast.LENGTH_SHORT).show()
        }

        adapter.onDeleteButtonClick = { item: Products, position: Int ->
            adapter.products.removeAt(position)
            Toast.makeText(applicationContext, "Successfully deleted the item!", Toast.LENGTH_SHORT).show()
            adapter.notifyDataSetChanged()

        }

        binding.floatingActionButton.setOnClickListener(){
            showAddDialog()

        }

        binding.myRecycler.adapter = adapter
        binding.myRecycler.layoutManager = LinearLayoutManager(this)


    }

    fun showUpdateDialog(item:Products, position: Int) {

        val dialog = Dialog(this)
        val binding: QuantityDialogBinding = QuantityDialogBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()

        binding.btnUpdateQtyDialog.setOnClickListener() {
            var newQuantity: Int = binding.tvQuantityDialog.text.toString().toInt()
            adapter.products[position].quantity = newQuantity
            adapter.notifyDataSetChanged()
            dialog.dismiss()
        }
    }
    fun showAddDialog() {
        val dialog = Dialog(this)
        val binding: AddDialogBinding = AddDialogBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()

        val images = arrayListOf<String>("ic_baseline_brush_24",
                    "ic_baseline_car_repair_24", "ic_baseline_coffee_maker_24",
                    "ic_baseline_lock_open_24",
                    "ic_baseline_person_outline_24",
                    "ic_launcher_background",
                    "ic_launcher_foreground",
                    "paintbrush", "toyotagenuineparts", "coffeemaker", "nccheesyseafood")

        val spinnerAdapter = ArrayAdapter(applicationContext, R.layout.textview_xml, images)
        binding.spnimage.adapter = spinnerAdapter


        binding.dialogAddButton.setOnClickListener() {

            var image: Int = resources.getIdentifier(binding.spnimage.selectedItem.toString(),
                "drawable", packageName)
            var itemName: String = binding.etAddDialogName.text.toString()
            var itemDesc: String = binding.etDialogDescription.text.toString()
            var quantity = binding.etDialogQuantity.text.toString().toInt()

            adapter.products.add(Products(image, itemName, itemDesc, quantity))
            adapter.notifyItemInserted(adapter.itemCount + 1)
            dialog.dismiss()
        }


                //get data from another screen
//        var name = intent.getStringExtra("nameID")
//
//        binding.tvWelcome.text = "Welcome $name"
    }
}