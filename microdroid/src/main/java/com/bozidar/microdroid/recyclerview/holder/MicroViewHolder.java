package com.bozidar.microdroid.recyclerview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bozidar.microdroid.R;

import static com.bozidar.microdroid.recyclerview.adapter.MicroRecyclerAdapter.onMicroItemCLickListener;

/**
 * Created by bozidar on 20.04.15..
 */

public class MicroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView title;
    public TextView description;
    public ImageView icon;
    public String viewTag;
    private onMicroItemCLickListener listener;



    public MicroViewHolder(View itemView, onMicroItemCLickListener listener, String viewTag) {
        super(itemView);
        this.listener = listener;
        this.viewTag = viewTag;
        this.title = (TextView) itemView.findViewById(R.id.tvList);
        this.icon = (ImageView) itemView.findViewById(R.id.ivIcon);
        if(viewTag.equals("DetailedList"))
            this.description = (TextView) itemView.findViewById(R.id.tvList2);
        title.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.microItemClicked(view, getLayoutPosition());
    }


}