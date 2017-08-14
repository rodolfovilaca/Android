package com.example.rodolfo.kotlin1

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import java.util.*
import com.example.rodolfo.kotlin1.Flower
import com.example.rodolfo.kotlin1.AdapterConstants
import com.example.rodolfo.kotlin1.ViewType
import com.example.rodolfo.kotlin1.ViewTypeDelegateAdapter

/**
 * Created by conra on 24/03/2017.
 */
class FlowerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items: ArrayList<ViewType>
    private var delegateAdapters =  SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType{
        override fun getViewType() =  AdapterConstants.LOADING
    }

    init {
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.FLOWER,FlowerDelegateAdapter())
        items = ArrayList()
        items.add(loadingItem)
    }

    override fun getItemCount(): Int {
               return items.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType).onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, this.items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return this.items.get(position).getViewType()
    }

    fun addFlower(flowers: List<Flower>) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(flowers)
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1 /* plus loading item */)
    }

    fun clearAndAddFlower(flowers: List<Flower>) {
        items.clear()
        notifyItemRangeRemoved(0, getLastPosition())

        items.addAll(flowers)
        items.add(loadingItem)
        notifyItemRangeInserted(0, items.size)
    }

    fun getFlowers(): List<Flower> {
        return items
                .filter { it.getViewType() == AdapterConstants.FLOWER }
                .map { it as Flower }
    }

    private fun getLastPosition() = if (items.lastIndex == -1) 0 else items.lastIndex

}