package com.kodego.inventory.app.arguez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kodego.inventory.app.arguez.databinding.ActivityLoginv2InvAppBinding
import com.kodego.inventory.app.arguez.databinding.ActivityMainBinding

class Loginv2InvApp : AppCompatActivity() {

    //create lateinit var binding
    lateinit var binding: ActivityLoginv2InvAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginv2InvAppBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //login
        binding.btnLoginv2.setOnClickListener(){
            var userName: String = binding.etUserNamev2.text.toString()
            var password: String = binding.etPasswordv2.text.toString()
            checkCredential(userName, password)
    }
}
    private fun checkCredential(userName: String, password: String): Boolean {
        val correctUsername: String = "admin"
        val correctPassword: String = "admin123"

        val correctUsername2: String = "user_Paul"
        val correctPassword2: String = "pass123"

        if((correctUsername == userName) && (correctPassword == password)){
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("nameID", userName)
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext, "Logging in...", Toast.LENGTH_SHORT).show()
            return true
        }else if((correctUsername2 == userName) && (correctPassword2 == password)) {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("nameID", userName)
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext, "Logging in...", Toast.LENGTH_SHORT).show()
            return true
        }else{
            Toast.makeText(applicationContext, "Invalid Credentials. Try again.", Toast.LENGTH_SHORT).show()
            return false
        }
    }
}