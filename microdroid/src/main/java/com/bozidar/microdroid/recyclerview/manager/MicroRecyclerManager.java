package com.bozidar.microdroid.recyclerview.manager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.bozidar.microdroid.recyclerview.api.MicroRecyclerAPI;
import com.bozidar.microdroid.recyclerview.model.MicroSimpleModel;

import java.util.List;

/**
 * Created by bozidar on 21.04.15..
 */

public class MicroRecyclerManager {

    private List<MicroSimpleModel> data;
    private Context context;
    private RecyclerView recyclerView;

    private static MicroRecyclerManager manager;

    public static MicroRecyclerManager Builder() {
        if(manager == null){
            return manager = new MicroRecyclerManager();
        }
        return manager;
    }

    public MicroRecyclerManager build(){
        return manager;
    }

    public MicroRecyclerManager setInformation(RecyclerView recyclerView, List<MicroSimpleModel> data, Context context){
        this.data = data;
        this.context = context;
        this.recyclerView = recyclerView;
        return build();
    }

    public MicroRecyclerAPI buildSimpleRecyclerView() {
        return new MicroSimpleRecyclerView(recyclerView, data, context);
    }


    public MicroDetailRecyclerView buildDetailRecyclerView() {
        return new MicroDetailRecyclerView(recyclerView, data, context);
    }





}
