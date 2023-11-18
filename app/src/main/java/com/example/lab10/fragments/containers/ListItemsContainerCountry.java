package com.example.lab10.fragments.containers;

import com.example.lab10.R;
import com.example.lab10.adapters.ItemsListAdapterCountry;
import com.example.lab10.database.Database;
import com.example.lab10.database.entities.Country;
import com.example.lab10.fragments.element.WorkWithItemCountryFragment;
import com.example.lab10.fragments.element.WorkWithItemFragment;

import java.util.ArrayList;
import java.util.List;

public class ListItemsContainerCountry extends ListItemsContainer {
    List<Country> items = new ArrayList<>();

    @Override
    protected void setAdapter() {
        items = db.countryDao().getAllCountry();

        binding.itemsList.setAdapter(new ItemsListAdapterCountry(
                getContext(),
                R.layout.list_item_country,
                items));
    }

    @Override
    protected WorkWithItemFragment getWorkWithItemListFragment() {
        return new WorkWithItemCountryFragment();
    }
}
