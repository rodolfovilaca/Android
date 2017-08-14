package com.example.rodolfo.deltapratododia;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by conra on 22/03/2017.
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent, false);
        ViewHolder vh =  new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mText;
        public ImageView mImg;
        public ViewHolder(View itemView) {
            super(itemView);
            mText = itemView;
            mImg = itemView;
        }
    }

}
