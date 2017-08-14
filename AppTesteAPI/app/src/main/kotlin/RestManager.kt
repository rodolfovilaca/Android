package com.example.rodolfo.apptesteapi

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable


class RestManager {
    private val TAG = "RestManager"
    var flowerService: FlowerService? = null
    fun get(): FlowerService {
        if(flowerService == null) {
            val httpClient = OkHttpClient.Builder()
            val gson = GsonBuilder().setLenient().create()
            val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build()
            flowerService = retrofit.create<FlowerService>(FlowerService::class.java)
            Log.v(TAG, "" + flowerService)
        }
        return flowerService as FlowerService
    }
    /*fun getFlowerService(): Observable<List<Flower>> {
        return flowerService.getAllFlowers()
                .flatMap { flowerResult -> Observable.from(flowerResult) }
                .map {flower -> Flower(flower.category,flower.instructions,flower.productId,flower.name,flower.price, flower.photo)}
    }*/
        /*get() {
            if (mFlowerService == null) {
                Log.v(TAG, "Geting Service")
                val retrofit = Retrofit.Builder()
                        .baseUrl(Constants.HTTP.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                mFlowerService = retrofit.create(FlowerService::class.java)
            }
            return mFlowerService!!
        }*/
}
