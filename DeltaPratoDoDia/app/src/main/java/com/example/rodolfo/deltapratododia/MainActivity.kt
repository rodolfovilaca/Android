package com.example.rodolfo.deltapratododia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar

class MainActivity : AppCompatActivity() {
    internal var mToolbar: Toolbar
    internal var mRecycler: RecyclerView
    internal var mAdapter: RecyclerView.Adapter<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mToolbar = findViewById(R.id.my_toolbar) as Toolbar
        setSupportActionBar(mToolbar)

        mRecycler = findViewById(R.id.my_recycler_view) as RecyclerView
        mRecycler.setHasFixedSize(true)
        mRecycler.layoutManager = LinearLayoutManager(LinearLayoutManager.VERTICAL)
        mAdapter = MyAdapter()
        mRecycler.adapter = mAdapter
    }
}