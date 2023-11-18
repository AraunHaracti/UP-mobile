package com.example.lab10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lab10.database.entities.Country;

import java.util.List;

public class ItemListAdapter extends ArrayAdapter<Country> {
    private final LayoutInflater inflater;
    private final int layout;
    private final List<Country> items;

    public ItemListAdapter(Context context, int resource, List<Country> items) {
        super(context, resource, items);

        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Country country = items.get(position);

        viewHolder.itemListName.setText(country.name);

        return convertView;
    }

    private class ViewHolder {
        final TextView itemListName;
        ViewHolder(View view){
            itemListName = view.findViewById(R.id.item_list_name);
        }
    }
}
