package com.example.rodolfo.apptesteapi

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.util.ArrayList


class FlowerAdapter(private val mListener: FlowerAdapter.FlowerClickListener) : RecyclerView.Adapter<FlowerAdapter.Holder>() {
    private val mFlowers: MutableList<Flower>
    private val TAG = "FlowerAdapter"
    init {
        mFlowers = ArrayList<Flower>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.row_item, null, false)
        return Holder(row)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Log.v(TAG, "onBindViewHolder")
        val currFlower: Flower = mFlowers.get(position)

        holder.mName.setText(currFlower.name)
        holder.mPrice.setText(""+currFlower.price)

        //if (currFlower.isFromDatabase) {
           // holder.mPhoto.setImageBitmap(currFlower.picture)
        //} else {
        Picasso.with(holder.itemView.context).load(Constants.HTTP.BASE_URL + "/photos/" + currFlower.photo).into(holder.mPhoto)
        //}
    }

    override fun getItemCount(): Int {
        Log.v(TAG, "getItemCount() called")
        return mFlowers.size
    }

    fun addFlower(flower: Flower) {
        Log.v(TAG, ""+flower.photo)
        mFlowers.add(flower)
        Log.v(TAG, ""+mFlowers.size)
        notifyDataSetChanged()
    }

    fun getSelectedFlower(position: Int): Flower {
        return mFlowers[position]
    }

    fun reset() {
        mFlowers.clear()
        notifyDataSetChanged()
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val mPhoto: ImageView
        val mName: TextView
        val mPrice: TextView

        init {
            Log.v(TAG, "Holder")
            mPhoto = itemView.findViewById(R.id.flowerPhoto) as ImageView
            mName = itemView.findViewById(R.id.flowerName) as TextView
            mPrice = itemView.findViewById(R.id.flowerPrice) as TextView
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            mListener.onClick(layoutPosition)
        }
    }

    interface FlowerClickListener {

        fun onClick(position: Int)
    }
}
