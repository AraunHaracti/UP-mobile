package com.example.lab10.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.lab10.R;
import com.example.lab10.database.entities.Film;

import java.util.List;

public class ItemsListAdapterFilm extends ItemsListAdapter<Film, ItemsListAdapterFilm.FilmViewHolder>{
    public ItemsListAdapterFilm(Context context, int resource, List<Film> items) {
        super(context, resource, items);
    }

    @Override
    protected FilmViewHolder getViewHolder(View view) {
        return new FilmViewHolder(view);
    }

    @Override
    protected void setData(FilmViewHolder viewHolder, Film item) {
        viewHolder.nameFilm.setText(item.name);
        viewHolder.nameGenre.setText(db.genreDao().getGenre(item.genreId).name);
        viewHolder.nameCountry.setText(db.countryDao().getCountry(item.countryId).name);
    }

    public class FilmViewHolder extends ViewHolder
    {
        final TextView nameFilm;
        final TextView nameGenre;
        final TextView nameCountry;
        public FilmViewHolder(View view) {
            super(view);
            nameFilm = view.findViewById(R.id.name_film);
            nameGenre = view.findViewById(R.id.name_genre);
            nameCountry = view.findViewById(R.id.name_country);
        }
    }
}
