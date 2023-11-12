package com.example.lab10.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lab10.R;
import com.example.lab10.database.Database;
import com.example.lab10.database.entities.Country;

import java.util.List;

public abstract class ItemsListAdapter<T, V extends ItemsListAdapter.ViewHolder> extends ArrayAdapter<T> {
    private final LayoutInflater inflater;
    private final int layout;
    private final List<T> items;

    Database db;

    public ItemsListAdapter(Context context, int resource, List<T> items) {
        super(context, resource, items);

        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);

        db = Database.getDatabase(getContext());
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        V viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = getViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (V) convertView.getTag();
        }

        T item = items.get(position);

        setData(viewHolder, item);

        return convertView;
    }

    protected abstract V getViewHolder(View view);

    protected abstract void setData(V viewHolder, T item);

    public abstract static class ViewHolder {
        public ViewHolder(View view) {

        }
    }
}
