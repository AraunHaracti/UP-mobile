package com.example.lab10.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.lab10.R;
import com.example.lab10.database.Database;
import com.example.lab10.database.entities.Actor;
import com.example.lab10.database.entities.ActorInFilm;

import java.util.List;

public class ItemsListAdapterActorInFilm extends ItemsListAdapter<ActorInFilm, ItemsListAdapterActorInFilm.ActorInFilmViewHolder>{

    public ItemsListAdapterActorInFilm(Context context, int resource, List<ActorInFilm> items) {
        super(context, resource, items);
    }

    @Override
    protected ActorInFilmViewHolder getViewHolder(View view) {
        return new ActorInFilmViewHolder(view);
    }

    @Override
    protected void setData(ActorInFilmViewHolder viewHolder, ActorInFilm item) {
        Actor actor = db.actorDao().getActor(item.actorId);
        viewHolder.actor.setText((actor.name + " " + actor.surname));
        viewHolder.film.setText(db.filmDao().getFilm(item.filmId).name);
    }

    public class ActorInFilmViewHolder extends ViewHolder
    {
        final TextView actor;
        final TextView film;

        public ActorInFilmViewHolder(View view) {
            super(view);
            actor = view.findViewById(R.id.name_actor);
            film = view.findViewById(R.id.name_film);
        }
    }
}
