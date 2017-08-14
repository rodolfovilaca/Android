package com.example.rodolfo.kotlin1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.flowers_fragment.*
import com.example.rodolfo.kotlin1.FlowerAdapter
/**
 * Created by conra on 23/03/2017.
 */
class FlowersFragment : Fragment() {

    private val flowersList by lazy{
        flowers_list
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        flowersList?.setHasFixedSize(true)
        flowersList?.layoutManager = LinearLayoutManager(context)

        initAdapter()
        if (savedInstanceState == null)
        {
            val flower = mutableListOf<Flower>()
            for (i in 1..10) {
                flower.add(Flower(
                        "Name$i", "Title $i",
                        i, // number of comments
                        "http://lorempixel.com/200/200/technics/$i", // image url
                        i,"url"
                ))
            }
            (flowersList?.adapter as FlowerAdapter).addFlower(flower)
        }
    }

    private fun initAdapter() {
        if (flowersList?.adapter == null) {
            flowersList?.adapter = FlowerAdapter()
        }
    }
}