package com.example.lab10.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.lab10.R;
import com.example.lab10.database.entities.Genre;

import java.util.List;

public class ItemsListAdapterGenre extends ItemsListAdapter<Genre, ItemsListAdapterGenre.GenreViewHolder>{
    public ItemsListAdapterGenre(Context context, int resource, List<Genre> items) {
        super(context, resource, items);
    }

    @Override
    protected GenreViewHolder getViewHolder(View view) {
        return new GenreViewHolder(view);
    }

    @Override
    protected void setData(GenreViewHolder viewHolder, Genre item) {
        viewHolder.name.setText(item.name);
    }

    public class GenreViewHolder extends ViewHolder {
        final TextView name;

        public GenreViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name_genre);
        }
    }
}
