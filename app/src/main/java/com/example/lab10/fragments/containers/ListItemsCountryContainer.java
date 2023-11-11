package com.example.lab10.fragments.containers;

import com.example.lab10.R;
import com.example.lab10.adapters.CountryItemsListAdapter;
import com.example.lab10.database.Database;
import com.example.lab10.database.entities.Country;
import com.example.lab10.fragments.element.WorkWithRewardItemListFragment;

public class ListItemsCountryContainer extends ListItemsContainer {

    @Override
    protected Runnable setThread() {
        Database db = Database.getDatabase(this.getContext());

        return () -> {
            binding.itemsList.
                    setAdapter(
                            new CountryItemsListAdapter(
                                    getContext(),
                                    R.layout.list_item_1,
                                    db.countryDao().getAllCountry()));
        };
    }
}
