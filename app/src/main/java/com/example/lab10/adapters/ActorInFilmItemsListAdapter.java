package com.example.lab10.adapters;

import android.content.Context;

import com.example.lab10.database.entities.ActorInFilm;

import java.util.List;

public class ActorInFilmItemsListAdapter extends ItemsListAdapter<ActorInFilm>{
    public ActorInFilmItemsListAdapter(Context context, int resource, List<ActorInFilm> items) {
        super(context, resource, items);
    }

    @Override
    protected void setData(ItemsListAdapter<ActorInFilm>.ViewHolder viewHolder, ActorInFilm item) {
        viewHolder.itemListName_1.setText(item.actorId);
        viewHolder.itemListName_2.setText(item.filmId);
    }
}
