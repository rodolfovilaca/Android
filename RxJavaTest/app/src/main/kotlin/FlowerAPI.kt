package com.example.rodolfo.rxjavatest

import android.util.Log
import com.example.rodolfo.rxjavatest.FlowerService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class FlowerAPI {
    private val TAG = "RestManager"
    var flowerService: FlowerService? = null
    fun getFlowerAPI(): FlowerService {
        if (flowerService == null) {
            val httpClient = OkHttpClient.Builder()
            val gson = GsonBuilder().setLenient().create()
            val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build()
            flowerService = retrofit.create<FlowerService>(FlowerService::class.java)
            Log.v(TAG, "" + flowerService)
        }
        return flowerService as FlowerService
    }
}