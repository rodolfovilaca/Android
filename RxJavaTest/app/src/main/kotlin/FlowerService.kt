
package com.example.rodolfo.rxjavatest

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import rx.Observable

interface FlowerService{
    @GET("/feeds/flowers.json")
    fun getAllFlowers(): Observable<List<Flower>>
}