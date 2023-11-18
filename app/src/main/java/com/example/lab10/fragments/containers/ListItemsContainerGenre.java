package com.example.lab10.fragments.containers;

import com.example.lab10.R;
import com.example.lab10.adapters.ItemsListAdapterGenre;
import com.example.lab10.database.Database;
import com.example.lab10.database.entities.Genre;
import com.example.lab10.fragments.element.WorkWithItemFragment;
import com.example.lab10.fragments.element.WorkWithItemGenreFragment;

import java.util.ArrayList;
import java.util.List;

public class ListItemsContainerGenre extends ListItemsContainer {
    List<Genre> items = new ArrayList<>();

    @Override
    protected void setAdapter() {
        items = db.genreDao().getAllGenre();

        binding.itemsList.setAdapter(new ItemsListAdapterGenre(
                getContext(),
                R.layout.list_item_genre,
                items));
    }

    @Override
    protected WorkWithItemFragment getWorkWithItemListFragment() {
        return new WorkWithItemGenreFragment();
    }
}