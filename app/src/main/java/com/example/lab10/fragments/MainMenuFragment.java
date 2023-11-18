package com.example.lab10.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab10.R;
import com.example.lab10.databinding.FragmentMainMenuBinding;
import com.example.lab10.fragments.containers.ListItemsContainerActor;
import com.example.lab10.fragments.containers.ListItemsContainer;
import com.example.lab10.fragments.containers.ListItemsContainerActorInFilm;
import com.example.lab10.fragments.containers.ListItemsContainerCountry;
import com.example.lab10.fragments.containers.ListItemsContainerFilm;
import com.example.lab10.fragments.containers.ListItemsContainerGenre;
import com.example.lab10.fragments.containers.ListItemsContainerReward;
import com.example.lab10.fragments.containers.ListItemsContainerRewardForActor;

public class MainMenuFragment extends Fragment {

    FragmentMainMenuBinding binding;

    public MainMenuFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.openActors.setOnClickListener(v -> setChangingFragments(
                new ListItemsContainerActor(), "actors_list_fragment"));

        binding.openCountries.setOnClickListener(v -> setChangingFragments(
                new ListItemsContainerCountry(), "countries_list_fragment"));

        binding.openFilms.setOnClickListener(v -> setChangingFragments(
                new ListItemsContainerFilm(), "films_list_fragment"));

        binding.openActorsInFilms.setOnClickListener(v -> setChangingFragments(
                new ListItemsContainerActorInFilm(), "films_list_fragment"));

        binding.openRewardsForActors.setOnClickListener(v -> setChangingFragments(
                new ListItemsContainerRewardForActor(), "films_list_fragment"));

        binding.openRewards.setOnClickListener(v -> setChangingFragments(
                new ListItemsContainerReward(), "rewards_list_fragment"));

        binding.openGenres.setOnClickListener(v -> setChangingFragments(
                new ListItemsContainerGenre(), "genres_list_fragment"));
    }

    private void setChangingFragments(ListItemsContainer listItemsContainer, String tag)
    {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, listItemsContainer, tag)
                .addToBackStack("list_fragment_transaction")
                .commit();
    }
}