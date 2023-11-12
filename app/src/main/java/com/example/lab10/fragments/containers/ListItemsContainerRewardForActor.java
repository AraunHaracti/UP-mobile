package com.example.lab10.fragments.containers;

import com.example.lab10.R;
import com.example.lab10.adapters.ItemsListAdapterRewardForActor;
import com.example.lab10.database.entities.RewardForActor;
import com.example.lab10.fragments.element.WorkWithItemFragment;
import com.example.lab10.fragments.element.WorkWithItemRewardForActorFragment;

import java.util.ArrayList;
import java.util.List;

public class ListItemsContainerRewardForActor extends ListItemsContainer {
    List<RewardForActor> items = new ArrayList<>();

    @Override
    protected void setAdapter() {
        items = db.rewardForActorDao().getAllRewardForActor();

        binding.itemsList.setAdapter(new ItemsListAdapterRewardForActor(
                getContext(),
                R.layout.list_item_reward_for_actor,
                items));
    }

    @Override
    protected WorkWithItemFragment getWorkWithItemListFragment() {
        return new WorkWithItemRewardForActorFragment();
    }
}