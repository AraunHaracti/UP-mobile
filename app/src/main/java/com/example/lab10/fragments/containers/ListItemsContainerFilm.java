package com.example.lab10.fragments.containers;

import com.example.lab10.R;
import com.example.lab10.adapters.ItemsListAdapterFilm;
import com.example.lab10.database.Database;
import com.example.lab10.database.entities.Film;
import com.example.lab10.fragments.element.WorkWithItemFilmFragment;
import com.example.lab10.fragments.element.WorkWithItemFragment;

import java.util.ArrayList;
import java.util.List;

public class ListItemsContainerFilm extends ListItemsContainer {
    List<Film> items = new ArrayList<>();

    @Override
    protected void setAdapter() {
        items = db.filmDao().getAllFilm();

        binding.itemsList.setAdapter(new ItemsListAdapterFilm(
                getContext(),
                R.layout.list_item_film,
                items));
    }

    @Override
    protected WorkWithItemFragment getWorkWithItemListFragment() {
        return new WorkWithItemFilmFragment();
    }
}