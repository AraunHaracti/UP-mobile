package com.example.lab10.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lab10.R;
import com.example.lab10.database.entities.Country;

import java.util.List;

public class ItemsListAdapter<T> extends ArrayAdapter<T> {
    private final LayoutInflater inflater;
    private final int layout;
    private final List<T> items;

    public ItemsListAdapter(Context context, int resource, List<T> items) {
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

        T item = items.get(position);

        setData(viewHolder, item);

        return convertView;
    }

    protected void setData(ViewHolder viewHolder, T item)
    {

    }

    protected class ViewHolder {
        final TextView itemListName_1;
        final TextView itemListName_2;
        final TextView itemListName_3;
        ViewHolder(View view){
            itemListName_1 = view.findViewById(R.id.name_1);
            itemListName_2 = view.findViewById(R.id.name_2);
            itemListName_3 = view.findViewById(R.id.name_3);
        }
    }
}
