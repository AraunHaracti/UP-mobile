package com.example.lab10.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.lab10.R;
import com.example.lab10.database.entities.Reward;

import java.util.List;

public class ItemsListAdapterReward extends ItemsListAdapter<Reward, ItemsListAdapterReward.RewardViewHolder>{
    public ItemsListAdapterReward(Context context, int resource, List<Reward> items) {
        super(context, resource, items);
    }

    @Override
    protected RewardViewHolder getViewHolder(View view) {
        return new RewardViewHolder(view);
    }

    @Override
    protected void setData(RewardViewHolder viewHolder, Reward item) {
        viewHolder.name.setText(item.name);
        viewHolder.info.setText(item.info);
    }

    public class RewardViewHolder extends ViewHolder
    {
        final TextView name;
        final TextView info;
        public RewardViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name_reward);
            info = view.findViewById(R.id.info_reward);
        }
    }
}
