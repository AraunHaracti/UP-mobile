package com.example.lab10.fragments.containers;

import com.example.lab10.R;
import com.example.lab10.adapters.ItemsListAdapterActor;
import com.example.lab10.database.entities.Actor;
import com.example.lab10.fragments.element.WorkWithItemActorFragment;
import com.example.lab10.fragments.element.WorkWithItemFragment;

import java.util.ArrayList;
import java.util.List;

public class ListItemsContainerActor extends ListItemsContainer {
    List<Actor> items = new ArrayList<>();

    @Override
    protected void setAdapter() {
        items = db.actorDao().getAllActor();

        binding.itemsList.setAdapter(new ItemsListAdapterActor(
                getContext(),
                R.layout.list_item_actor,
                items));
    }

    @Override
    protected WorkWithItemFragment getWorkWithItemListFragment() {
        return new WorkWithItemActorFragment();
    }
}