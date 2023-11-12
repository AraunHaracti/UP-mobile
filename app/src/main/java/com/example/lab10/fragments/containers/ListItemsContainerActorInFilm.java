package com.example.lab10.fragments.containers;

import com.example.lab10.R;
import com.example.lab10.adapters.ItemsListAdapterActor;
import com.example.lab10.adapters.ItemsListAdapterActorInFilm;
import com.example.lab10.database.entities.Actor;
import com.example.lab10.database.entities.ActorInFilm;
import com.example.lab10.fragments.element.WorkWithItemActorInFilmFragment;
import com.example.lab10.fragments.element.WorkWithItemFragment;

import java.util.ArrayList;
import java.util.List;

public class ListItemsContainerActorInFilm extends ListItemsContainer {
    List<ActorInFilm> items = new ArrayList<>();

    @Override
    protected void setAdapter() {
        items = db.actorInFilmDao().getAllActorInFilm();

        binding.itemsList.setAdapter(new ItemsListAdapterActorInFilm(
                getContext(),
                R.layout.list_item_actor_in_film,
                items));
    }

    @Override
    protected WorkWithItemFragment getWorkWithItemListFragment() {
        return new WorkWithItemActorInFilmFragment();
    }
}