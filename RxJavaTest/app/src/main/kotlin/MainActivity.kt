package com.example.rodolfo.rxjavatest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rx.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity(),FlowerAdapter.FlowerClickListener {
    //var flower: Flower? = null
    private lateinit var mFlowerAdapter: FlowerAdapter
    //private val mFlowerAdapter by lazy { FlowerAdapter(this) }
    private val TAG = "MainActivity"
    private var sub: Subscription? = null
    //val mManager by lazy{RestManager()}

    override fun onClick(position: Int) {
        //val selectedFlower: Flower = mFlowerAdapter.getSelectedFlower(position)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v(TAG, "onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configViews()
        val api = RestManager()
        Log.i(TAG, ""+api)
        sub = api.flowerService.getAllFlowers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object: Subscriber<List<Flower>>(){
                    override fun onCompleted(){

                    }
                    override fun onError(t: Throwable){
                        Log.d(TAG, "Error")
                    }
                    override fun onNext(response: List<Flower>){
                        for (i in 0..response.size-1){
                            val flower: Flower = response[i]
                            mFlowerAdapter.addFlower(flower)
                        }
                    }
                })
        /*Log.d(TAG, "Array size: "+flowers.size)
        for (i in 0..flowers.size){
            val flower =  flowers[i]
            mFlowerAdapter.addFlower(flower)
        }*/
    }

    override fun onDestroy() {
        super.onDestroy()
        if (sub != null && !sub?.isUnsubscribed()!!){
            sub!!.unsubscribe()
        }
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