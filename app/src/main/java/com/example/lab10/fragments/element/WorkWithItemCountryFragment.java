package com.example.lab10.fragments.element;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab10.database.entities.Country;
import com.example.lab10.databinding.FragmentWorkWithItemCountryBinding;

public class WorkWithItemCountryFragment extends WorkWithItemFragment {

    FragmentWorkWithItemCountryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWorkWithItemCountryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void elementsInit(){
        binding.insertBtn.setOnClickListener((v)->{

            String name = binding.name.getText().toString();

            Country item = new Country(name);

            database.countryDao().insert(item);

            getActivity().getSupportFragmentManager().popBackStack();
        });
    }
}