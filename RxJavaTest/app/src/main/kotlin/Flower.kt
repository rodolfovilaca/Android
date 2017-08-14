package com.example.rodolfo.rxjavatest


data class FlowerList (val array : List<Flower>)

data class Flower(val category: String,
                  val price: Double,
                  val instructions: String,
                  val photo: String,
                  val name: String,
                  val productId: Int)