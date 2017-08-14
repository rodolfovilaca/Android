package com.example.rodolfo.apptesteapi

import retrofit2.Call
import retrofit2.http.GET
import rx.Observable

interface FlowerService{
    @GET("/feeds/flowers.json")
    fun getAllFlowers(): Call<List<Flower>>
}