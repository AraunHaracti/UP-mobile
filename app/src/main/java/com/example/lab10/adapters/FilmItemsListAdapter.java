package com.example.lab10.adapters;

import android.content.Context;

import com.example.lab10.database.entities.Film;

import java.util.List;

public class FilmItemsListAdapter extends ItemsListAdapter<Film>{
    public FilmItemsListAdapter(Context context, int resource, List<Film> items) {
        super(context, resource, items);
    }

    @Override
    protected void setData(ItemsListAdapter<Film>.ViewHolder viewHolder, Film item) {
        viewHolder.itemListName_1.setText(item.name);
        viewHolder.itemListName_2.setText(item.countryId);
        viewHolder.itemListName_3.setText(item.genreId);
    }
}
