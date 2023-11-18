package com.example.lab10.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.lab10.R;
import com.example.lab10.database.entities.Actor;
import com.example.lab10.database.entities.RewardForActor;

import java.util.List;

public class ItemsListAdapterRewardForActor extends ItemsListAdapter<RewardForActor, ItemsListAdapterRewardForActor.RewardForActorViewHolder>{
    public ItemsListAdapterRewardForActor(Context context, int resource, List<RewardForActor> items) {
        super(context, resource, items);
    }

    @Override
    protected RewardForActorViewHolder getViewHolder(View view) {
        return new RewardForActorViewHolder(view);
    }

    @Override
    protected void setData(RewardForActorViewHolder viewHolder, RewardForActor item) {
        Actor actor = db.actorDao().getActor(item.actorId);
        viewHolder.nameActor.setText((actor.name + " " + actor.surname));
        viewHolder.nameReward.setText(db.rewardDao().getReward(item.rewardId).name);
    }

    public class RewardForActorViewHolder extends ViewHolder {
        final TextView nameReward;
        final TextView nameActor;
        public RewardForActorViewHolder(View view) {
            super(view);
            nameReward = view.findViewById(R.id.name_reward);
            nameActor = view.findViewById(R.id.name_actor);
        }
    }
}
