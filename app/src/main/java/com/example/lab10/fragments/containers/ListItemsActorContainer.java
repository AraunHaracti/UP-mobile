package com.example.lab10.fragments.containers;

import com.example.lab10.R;
import com.example.lab10.adapters.ActorItemsListAdapter;
import com.example.lab10.database.Database;
import com.example.lab10.fragments.element.WorkWithItemListFragment;

public class ListItemsActorContainer extends ListItemsContainer {


    @Override
    protected Runnable setThread() {
        Database db = Database.getDatabase(this.getContext());

        return () -> {
            binding.itemsList.
                    setAdapter(
                            new ActorItemsListAdapter(
                                    getContext(),
                                    R.layout.list_item_3,
                                    db.actorDao().getAllActor()));
        };
    }
}