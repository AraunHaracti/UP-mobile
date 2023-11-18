package com.example.lab10.fragments.containers;

import com.example.lab10.R;
import com.example.lab10.adapters.ItemsListAdapterReward;
import com.example.lab10.database.Database;
import com.example.lab10.database.entities.Reward;
import com.example.lab10.fragments.element.WorkWithItemFragment;
import com.example.lab10.fragments.element.WorkWithItemRewardFragment;

import java.util.ArrayList;
import java.util.List;

public class ListItemsContainerReward extends ListItemsContainer {
    List<Reward> items = new ArrayList<>();

    @Override
    protected void setAdapter() {
        items = db.rewardDao().getAllReward();

        binding.itemsList.setAdapter(new ItemsListAdapterReward(
                getContext(),
                R.layout.list_item_reward,
                items));
    }

    @Override
    protected WorkWithItemFragment getWorkWithItemListFragment() {
        return new WorkWithItemRewardFragment();
    }
}