package com.example.lab10.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.lab10.R;
import com.example.lab10.database.Database;
import com.example.lab10.database.entities.Actor;

import java.util.List;

public class ItemsListAdapterActor extends ItemsListAdapter<Actor, ItemsListAdapterActor.ActorViewHolder>{
    public ItemsListAdapterActor(Context context, int resource, List<Actor> items) {
        super(context, resource, items);
    }

    @Override
    protected ActorViewHolder getViewHolder(View view) {
        return new ActorViewHolder(view);
    }

    @Override
    protected void setData(ActorViewHolder viewHolder, Actor item) {
        viewHolder.name.setText(item.name);
        viewHolder.surname.setText(item.surname);
        viewHolder.countryName.setText(db.countryDao().getCountry(item.countryId).name);
    }

    public class ActorViewHolder extends ViewHolder {
        final TextView name;
        final TextView surname;
        final TextView countryName;

        public ActorViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name_actor);
            surname = view.findViewById(R.id.surname_actor);
            countryName = view.findViewById(R.id.name_country);
        }
    }
}
