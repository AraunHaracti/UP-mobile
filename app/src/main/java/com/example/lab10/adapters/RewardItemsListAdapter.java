package com.example.lab10.adapters;

import android.content.Context;

import com.example.lab10.database.entities.Reward;

import java.util.List;

public class RewardItemsListAdapter extends ItemsListAdapter<Reward>{
    public RewardItemsListAdapter(Context context, int resource, List<Reward> items) {
        super(context, resource, items);
    }

    @Override
    protected void setData(ItemsListAdapter<Reward>.ViewHolder viewHolder, Reward item) {
        viewHolder.itemListName_1.setText(item.name);
        viewHolder.itemListName_1.setText(item.info);
    }
}
