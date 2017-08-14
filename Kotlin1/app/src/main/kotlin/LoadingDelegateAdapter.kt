package com.example.rodolfo.kotlin1
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.rodolfo.kotlin1.R
import com.example.rodolfo.kotlin1.inflate

/**
 * Created by conra on 24/03/2017.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter{
    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }
    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.news_item_loading)) {
    }
}