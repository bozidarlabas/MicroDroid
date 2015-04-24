package com.bozidar.microdroid.recyclerview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bozidar.microdroid.R;

/**
 * Created by bozidar on 20.04.15..
 */

public class MicroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView title;
    public ImageView icon;
    private com.bozidar.microdroid.recyclerview.adapter.MicroRecyclerAdapter.onMicroItemCLickListener listener;



    public MicroViewHolder(View itemView, com.bozidar.microdroid.recyclerview.adapter.MicroRecyclerAdapter.onMicroItemCLickListener listener) {
        super(itemView);
        this.listener = listener;
        this.title = (TextView) itemView.findViewById(R.id.tvList);
        this.icon = (ImageView) itemView.findViewById(R.id.ivIcon);
        title.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.microItemClicked(view, getLayoutPosition());
    }
}