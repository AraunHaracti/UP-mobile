package com.example.lab10.adapters;

import android.content.Context;

import com.example.lab10.database.entities.Country;

import java.util.List;

public class CountryItemsListAdapter extends ItemsListAdapter<Country>{
    public CountryItemsListAdapter(Context context, int resource, List<Country> items) {
        super(context, resource, items);
    }

    @Override
    protected void setData(ItemsListAdapter<Country>.ViewHolder viewHolder, Country item) {
        viewHolder.itemListName_1.setText(item.name);
    }
}
