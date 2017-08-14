package com.example.rodolfo.rxjavatest

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import rx.Subscriber
import rx.functions.Func0
import rx.functions.Func1


class RestManager {
    private val TAG = "RestManager"
    val flowerService: FlowerService
    //var flower: Flower? = null

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
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

    /*fun getObservable(): Observable<FlowerList> {
        Log.d(TAG, "Getting Observable")
        val flowerList =  flowerService.getAllFlowers()
        return flowerList
                //.flatMap { flowerList -> Observable.from(flowerList.array) }
                //.flatMap { flower -> Observable.just(Flower(flower.category,flower.price,flower.instructions,flower.photo,flower.name,flower.productId))}
    }*/
}
