package com.example.rodolfo.apptesteapi

import android.graphics.Bitmap

data class FlowerResult(val result: List<FlowerAPI>)

data class FlowerAPI(val category: String,
                  val instructions: String,
                  val photo: String,
                  val productId: String,
                  val name: String,
                  val price: String)
