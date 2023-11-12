package com.example.lab10.fragments.element;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab10.R;
import com.example.lab10.database.entities.Country;
import com.example.lab10.database.entities.Genre;
import com.example.lab10.databinding.FragmentWorkWithItemCountryBinding;
import com.example.lab10.databinding.FragmentWorkWithItemGenreBinding;

public class WorkWithItemGenreFragment extends WorkWithItemFragment {

    FragmentWorkWithItemGenreBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWorkWithItemGenreBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void elementsInit(){
        binding.insertBtn.setOnClickListener((v)->{

            String name = binding.name.getText().toString();

            Genre item = new Genre(name);

            database.genreDao().insert(item);

            getActivity().getSupportFragmentManager().popBackStack();
        });
    }
}