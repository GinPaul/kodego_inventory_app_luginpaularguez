package com.kodego.inventory.app.arguez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kodego.inventory.app.arguez.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //create lateinit var binding
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //login
        binding.btnLogin.setOnClickListener(){
            var userName: String = binding.etvUserName.text.toString()
            var password: String = binding.etvPassword.text.toString()
            checkCredential(userName, password)
        }
    }

    private fun checkCredential(userName: String, password: String): Boolean {
        val correctUsername: String = "admin"
        val correctPassword: String = "admin123"

        val correctUsername2: String = "Paul"
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

//sample test case to be eventually used
//assertEquals(checkCredential("admin", "admin123"), true)