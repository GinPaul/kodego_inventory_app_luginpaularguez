package com.kodego.inventory.app.arguez

import android.accounts.AuthenticatorDescription

data class Products (val imageName: Int, val itemName: String, val itemDescription: String, var quantity: Int) //<<var for quantity to be able to adjust the quantity