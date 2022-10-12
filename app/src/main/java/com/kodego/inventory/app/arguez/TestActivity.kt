package com.kodego.inventory.app.arguez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.kodego.inventory.app.arguez.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //button, edittext
        binding.btnGetName.setOnClickListener() {
//            Toast.makeText(applicationContext, "Hello from Toast", Toast.LENGTH_LONG).show()
            var name: String = binding.etvName.text.toString()
            binding.txtName.text = name
            Toast.makeText(applicationContext, "Name Input Success!", Toast.LENGTH_LONG).show()

//            var spinnerItem = binding.spinnerId.selectedItem.toString()
//            Toast.makeText(applicationContext, spinnerItem, Toast.LENGTH_SHORT).show()

        }

        binding.radioGroup.setOnCheckedChangeListener { radioGroup, checkedOption ->
            when(checkedOption){
                R.id.rb1 -> Toast.makeText(applicationContext, "Option 1 Selected", Toast.LENGTH_SHORT).show()
                R.id.rb2 -> Toast.makeText(applicationContext, "Option 2 Selected", Toast.LENGTH_SHORT).show()
                R.id.rb3 -> Toast.makeText(applicationContext, "Option 3 Selected", Toast.LENGTH_SHORT).show()
            }
        }

        binding.cb1.setOnClickListener(){
            if(binding.cb1.isChecked){
                Toast.makeText(applicationContext, "Checkbox 1 is checked", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Checkbox 1 is unchecked", Toast.LENGTH_SHORT).show()
            }
        }

        binding.cb2.setOnClickListener(){
            if(binding.cb2.isChecked){
                Toast.makeText(applicationContext, "Checkbox 2 is checked", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Checkbox 2 is unchecked", Toast.LENGTH_SHORT).show()
            }
        }

        val data = arrayListOf<String>("Option 1", "Option 2", "Option 3")
        val adapterParent = ArrayAdapter(applicationContext, R.layout.textview_xml, data)

        binding.spinnerId.adapter = adapterParent

        binding.btnGetSpinner.setOnClickListener() {
            var spinnerItem = binding.spinnerId.selectedItem.toString()
            Toast.makeText(applicationContext, spinnerItem, Toast.LENGTH_SHORT).show()
        }

        binding.switchButton.setOnClickListener(){
            if(binding.switchButton.isChecked){
                Toast.makeText(applicationContext, "On", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Off", Toast.LENGTH_SHORT).show()
            }
        }


    }
}