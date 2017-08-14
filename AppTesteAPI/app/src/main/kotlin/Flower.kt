package com.example.rodolfo.apptesteapi

import android.graphics.Bitmap

data class Flower(val category: String,
                  val instructions: String,
                  val photo: String,
                  val productId: Int,
                  val name: String,
                  val price: Double)
                  //val picture: Bitmap?,
                  //val isFromDatabase: Boolean)