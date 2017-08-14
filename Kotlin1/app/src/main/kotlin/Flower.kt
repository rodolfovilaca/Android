package com.example.rodolfo.kotlin1

import com.example.rodolfo.kotlin1.ViewType

data class Flower (
        var name:String,
        var category:String,
        var price:Int,
        var instructions:String,
        var productId:Int,
        var imgName: String): ViewType {
    override fun getViewType() = AdapterConstants.FLOWER
}