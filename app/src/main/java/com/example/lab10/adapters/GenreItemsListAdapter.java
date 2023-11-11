package com.example.lab10.adapters;

import android.content.Context;

import com.example.lab10.database.entities.Genre;

import java.util.List;

public class GenreItemsListAdapter extends ItemsListAdapter<Genre>{
    public GenreItemsListAdapter(Context context, int resource, List<Genre> items) {
        super(context, resource, items);
    }

    @Override
    protected void setData(ItemsListAdapter<Genre>.ViewHolder viewHolder, Genre item) {
        viewHolder.itemListName_1.setText(item.name);
    }
}
