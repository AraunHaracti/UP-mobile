package com.example.lab10.fragments.containers;

import com.example.lab10.R;
import com.example.lab10.adapters.GenreItemsListAdapter;
import com.example.lab10.database.Database;
import com.example.lab10.fragments.element.WorkWithRewardItemListFragment;

public class ListItemsGenreContainer extends ListItemsContainer {

    @Override
    protected Runnable setThread() {
        Database db = Database.getDatabase(this.getContext());

        return () -> {
            binding.itemsList.
                    setAdapter(
                            new GenreItemsListAdapter(
                                    getContext(),
                                    R.layout.list_item_1,
                                    db.genreDao().getAllGenre()));
        };
    }
}