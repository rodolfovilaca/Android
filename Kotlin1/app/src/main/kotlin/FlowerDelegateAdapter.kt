
package com.example.rodolfo.kotlin1

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kotlinx.android.synthetic.main.flower_row.view.*


class FlowerDelegateAdapter : ViewTypeDelegateAdapter{

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return LoadingDelegateAdapter.TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as Flower)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.flower_row)) {
        fun bind(item: Flower) = with(itemView) {
            //Picasso.with(itemView.context).load(item.thumbnail).into(img_thumbnail)
            img_flower.loadImg(item.imgName)
            name_flower.text = item.name
            description_flower.text = item.instructions
        }
    }
}