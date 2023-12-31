package com.example.lab10.fragments.element;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab10.database.entities.Reward;
import com.example.lab10.databinding.FragmentWorkWithItemRewardBinding;

public class WorkWithItemRewardFragment extends WorkWithItemFragment {

    FragmentWorkWithItemRewardBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWorkWithItemRewardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void elementsInit(){
        binding.insertBtn.setOnClickListener((v)->{

            String name = binding.name.getText().toString();
            String info = binding.info.getText().toString();

            Reward item = new Reward(name, info);

            database.rewardDao().insert(item);

            getActivity().getSupportFragmentManager().popBackStack();
        });
    }
}