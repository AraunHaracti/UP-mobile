package com.example.lab10.fragments.containers;

import com.example.lab10.R;
import com.example.lab10.adapters.FilmItemsListAdapter;
import com.example.lab10.database.Database;
import com.example.lab10.fragments.element.WorkWithRewardItemListFragment;

public class ListItemsFilmContainer extends ListItemsContainer {


    @Override
    protected Runnable setThread() {
        Database db = Database.getDatabase(this.getContext());

        return () -> {
            binding.itemsList.
                    setAdapter(
                            new FilmItemsListAdapter(
                                    getContext(),
                                    R.layout.list_item_3,
                                    db.filmDao().getAllFilm()));
        };
    }
}