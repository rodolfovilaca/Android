package com.example.rodolfo.apptesteapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.widget.Toast
import mu.KLogging
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class MainActivity : AppCompatActivity(), FlowerAdapter.FlowerClickListener {
    private lateinit var mFlowerAdapter: FlowerAdapter
    private var flowers =  mutableListOf<String>()
    //private val mFlowerAdapter by lazy { FlowerAdapter(this) }
    private val TAG = "MainActivity"
    val mManager by lazy{RestManager()}

    override fun onClick(position: Int) {
        //val selectedFlower: Flower = mFlowerAdapter.getSelectedFlower(position)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v(TAG, "onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configViews()
        val api: RestManager = RestManager()
        val listCall: Call<List<Flower>> = api.get().getAllFlowers()
        Log.i(TAG, ""+listCall)
        listCall.enqueue(object : Callback<List<Flower>> {
            override fun onResponse(call: Call<List<Flower>>?,response: Response<List<Flower>>) {
                Log.v(TAG, "onResponse")
                if (response.isSuccessful()) {
                    val flowerList = response.body()

                    for (i in 0..flowerList.size-1) {
                        val flower = flowerList[i]
                        mFlowerAdapter.addFlower(flower)
                    }
                } else {
                    val sc = response.code()
                    when (sc) {
                        400 -> Log.e("Error 400", "Bad Request")
                        404 -> Log.e("Error 404", "Not Found")
                        else -> Log.e("Error", "Generic Error")
                    }
                }
            }

            override fun onFailure(call: Call<List<Flower>>?, t: Throwable) {
                Log.v(TAG, "onFailure")
                Toast.makeText(getApplicationContext(), t.message, Toast.LENGTH_LONG).show()
            }
        })

    }
    fun configViews(){
        val mToolbar = findViewById(R.id.my_toolbar) as Toolbar
        setSupportActionBar(mToolbar)
        mToolbar.setTitle("Teste Server API")

        val mRecycler = findViewById(R.id.flowers_list) as RecyclerView
        mRecycler.setHasFixedSize(true)
        mRecycler.layoutManager =  LinearLayoutManager(this)
        mFlowerAdapter =  FlowerAdapter(this)
        mRecycler.setAdapter(mFlowerAdapter)
        Log.v(TAG, "configViews()")
    }
}
