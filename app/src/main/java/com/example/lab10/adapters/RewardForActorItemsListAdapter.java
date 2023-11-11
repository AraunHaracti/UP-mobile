package com.example.lab10.adapters;

import android.content.Context;

import com.example.lab10.database.entities.RewardForActor;

import java.util.List;

public class RewardForActorItemsListAdapter extends ItemsListAdapter<RewardForActor>{
    public RewardForActorItemsListAdapter(Context context, int resource, List<RewardForActor> items) {
        super(context, resource, items);
    }

    @Override
    protected void setData(ItemsListAdapter<RewardForActor>.ViewHolder viewHolder, RewardForActor item) {
        viewHolder.itemListName_1.setText(item.actorId);
        viewHolder.itemListName_2.setText(item.rewardId);
    }
}
