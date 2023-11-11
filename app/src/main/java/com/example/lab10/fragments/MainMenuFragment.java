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
import com.example.lab10.fragments.containers.ListItemsActorContainer;
import com.example.lab10.fragments.containers.ListItemsCountryContainer;
import com.example.lab10.fragments.containers.ListItemsFilmContainer;
import com.example.lab10.fragments.containers.ListItemsGenreContainer;
import com.example.lab10.fragments.containers.ListItemsRewardContainer;

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

        binding.openActors.setOnClickListener(view1 -> {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, new ListItemsActorContainer(), "actors_list_fragment")
                    .addToBackStack("list_fragment_transaction")
                    .commit();
        });

        binding.openCountries.setOnClickListener(view1 -> {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, new ListItemsCountryContainer(), "countries_list_fragment")
                    .addToBackStack(null)
                    .commit();
        });

        binding.openFilms.setOnClickListener(view1 -> {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, new ListItemsFilmContainer(), "films_list_fragment")
                    .addToBackStack(null)
                    .commit();
        });

        binding.openRewards.setOnClickListener(view1 -> {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, new ListItemsRewardContainer(), "rewards_list_fragment")
                    .addToBackStack("list_fragment_transaction")
                    .commit();
        });

        binding.openGenres.setOnClickListener(view1 -> {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, new ListItemsGenreContainer(), "genres_list_fragment")
                    .addToBackStack("list_fragment_transaction")
                    .commit();
        });
    }
}