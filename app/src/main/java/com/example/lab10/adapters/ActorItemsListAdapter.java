package com.example.lab10.adapters;

import android.content.Context;

import com.example.lab10.database.entities.Actor;

import java.util.List;

public class ActorItemsListAdapter extends ItemsListAdapter<Actor>{
    public ActorItemsListAdapter(Context context, int resource, List<Actor> items) {
        super(context, resource, items);
    }

    @Override
    protected void setData(ItemsListAdapter<Actor>.ViewHolder viewHolder, Actor item) {
        viewHolder.itemListName_1.setText(item.name);
        viewHolder.itemListName_2.setText(item.surname);
        viewHolder.itemListName_3.setText(item.countryId);
    }
}
