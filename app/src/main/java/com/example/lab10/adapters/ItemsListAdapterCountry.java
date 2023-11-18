package com.example.lab10.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.lab10.R;
import com.example.lab10.database.entities.Country;

import java.util.List;

public class ItemsListAdapterCountry extends ItemsListAdapter<Country, ItemsListAdapterCountry.CountryViewHolder>{

    public ItemsListAdapterCountry(Context context, int resource, List<Country> items) {
        super(context, resource, items);
    }

    @Override
    protected CountryViewHolder getViewHolder(View view) {
        return new CountryViewHolder(view);
    }

    @Override
    protected void setData(CountryViewHolder viewHolder, Country item) {
        viewHolder.nameCountry.setText(item.name);
    }


    public class CountryViewHolder extends ViewHolder {
        final TextView nameCountry;

        public CountryViewHolder(View view) {
            super(view);
            nameCountry = view.findViewById(R.id.name_country);
        }
    }
}
