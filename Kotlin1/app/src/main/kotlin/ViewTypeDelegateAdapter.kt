package com.example.rodolfo.kotlin1

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by conra on 24/03/2017.
 */
interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}