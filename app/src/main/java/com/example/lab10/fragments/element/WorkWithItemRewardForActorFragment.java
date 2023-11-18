package com.example.lab10.fragments.element;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.lab10.R;
import com.example.lab10.database.Database;
import com.example.lab10.database.entities.Actor;
import com.example.lab10.database.entities.Country;
import com.example.lab10.database.entities.Film;
import com.example.lab10.database.entities.Genre;
import com.example.lab10.database.entities.Reward;
import com.example.lab10.database.entities.RewardForActor;
import com.example.lab10.databinding.FragmentWorkWithItemFilmBinding;
import com.example.lab10.databinding.FragmentWorkWithItemRewardForActorBinding;

import java.util.ArrayList;
import java.util.List;

public class WorkWithItemRewardForActorFragment extends WorkWithItemFragment {
    FragmentWorkWithItemRewardForActorBinding binding;

    public WorkWithItemRewardForActorFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWorkWithItemRewardForActorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    List<Reward> rewards;
    List<Actor> actors;
    int reward_id;
    int actor_id;

    @Override
    protected void elementsInit(){
        Database db = Database.getDatabase(getContext());

        rewards = db.rewardDao().getAllReward();
        actors = db.actorDao().getAllActor();

        List<String> rewardsName = new ArrayList<>();
        for (Reward item: rewards) {
            rewardsName.add(item.name);
        }
        List<String> actorsName = new ArrayList<>();
        for (Actor item: actors) {
            actorsName.add(item.name + " " + item.surname);
        }

        ArrayAdapter<String> rewardsAdapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_item, rewardsName);
        ArrayAdapter<String> actorsAdapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_item, actorsName);

        rewardsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        actorsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.nameReward.setAdapter(rewardsAdapter);
        binding.nameActor.setAdapter(actorsAdapter);

        binding.nameReward.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                reward_id = rewards.get((int) id).id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.nameActor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                actor_id = actors.get((int) id).id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.insertBtn.setOnClickListener((v)->{
            RewardForActor item = new RewardForActor(reward_id, actor_id);

            database.rewardForActorDao().insert(item);

            getActivity().getSupportFragmentManager().popBackStack();
        });
    }
}