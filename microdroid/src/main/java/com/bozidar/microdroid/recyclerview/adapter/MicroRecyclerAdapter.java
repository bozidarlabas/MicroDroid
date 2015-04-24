package com.bozidar.microdroid.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bozidar.microdroid.recyclerview.holder.MicroViewHolder;
import com.bozidar.microdroid.recyclerview.model.MicroSimpleModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by bozidar on 20.04.15..
 */
public class MicroRecyclerAdapter extends RecyclerView.Adapter<MicroViewHolder> {

    private Context context;
    private int layoutResource;
    private List<MicroSimpleModel> data = Collections.emptyList();
    private onMicroItemCLickListener listener;

    public MicroRecyclerAdapter(Context context, int layoutResource, List<MicroSimpleModel> data) {
        listener = null;
        this.context = context;
        this.data = data;
        this.layoutResource = layoutResource;
    }

    /**
     * Called when RecyclerView needs a new ViewHolder of the giver type to represent an item
     *
     * @param parent   Layout root of micro_drawer_item
     * @param viewType The View type of the new View
     * @return A new ViewHolder that holds a View of the give view type
     */
    @Override
    public MicroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(layoutResource, parent, false);
        return new MicroViewHolder(v, listener);
    }

    /**
     * Called by RecyclerView to display the data at the specified position
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the item at the give position in the data set
     * @param position The position of the item within the adapter's data set
     */
    @Override
    public void onBindViewHolder(MicroViewHolder holder, int position) {
        MicroSimpleModel currentObject = data.get(position);
        holder.title.setText(currentObject.getText());
        //holder.icon.setImageResource(currentObject.iconId);
    }

    public void setOnMicroCLickListener(onMicroItemCLickListener listener){
        this.listener = listener;
    }

    /**
     * Returns the total number of items in the data set hold by the adapter
     *
     * @return The total number of items in this adapter
     */
    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public interface onMicroItemCLickListener{
        public void microItemClicked(View view, int position);
    }

}

//DataModel    -> represents single item in list
//Adapter      -> hold all items and show them using ViewHolder
//ContentView  ->
//ViewHolder   -> xml layout for single item inflated into java code
//RecyclerView -> use ViewHolder to display every item

//LayoutManager -> allow me to customize how the items are placed (bellow, near...)
//ItemAnimator  -> used for animating recycler view
//ItemDecorator -> set RecyclerView in different section