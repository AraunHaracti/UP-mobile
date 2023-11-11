package com.example.lab10.fragments.containers;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab10.R;
import com.example.lab10.adapters.RewardItemsListAdapter;
import com.example.lab10.database.Database;
import com.example.lab10.fragments.element.WorkWithCountryItemFragment;
import com.example.lab10.fragments.element.WorkWithItemListFragment;
import com.example.lab10.fragments.element.WorkWithRewardItemListFragment;

public class ListItemsRewardContainer extends ListItemsContainer {

    @Override
    protected Runnable setThread() {
        Database db = Database.getDatabase(this.getContext());

        return () -> {
            binding.itemsList.
                    setAdapter(
                            new RewardItemsListAdapter(
                                    getContext(),
                                    R.layout.list_item_reward,
                                    db.rewardDao().getAllReward()));
        };
    }

    @Override
    protected void addItemBtnInit(){
        binding.addItemBtn.setOnClickListener((view)->{
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment, new WorkWithRewardItemListFragment(),"add_item")
                    .addToBackStack(null)
                    .commit();
        });
    }
}