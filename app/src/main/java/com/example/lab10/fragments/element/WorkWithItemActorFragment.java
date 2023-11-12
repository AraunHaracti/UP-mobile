package com.example.lab10.fragments.element;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.lab10.R;
import com.example.lab10.adapters.ItemsListAdapterGenre;
import com.example.lab10.database.Database;
import com.example.lab10.database.entities.Actor;
import com.example.lab10.database.entities.Country;
import com.example.lab10.database.entities.Genre;
import com.example.lab10.databinding.FragmentWorkWithItemActorBinding;

import java.util.ArrayList;
import java.util.List;

public class WorkWithItemActorFragment extends WorkWithItemFragment {

    FragmentWorkWithItemActorBinding binding;

    public WorkWithItemActorFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWorkWithItemActorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    List<Country> countries;
    int name_country;

    @Override
    protected void elementsInit(){
        Database db = Database.getDatabase(getContext());

        countries = db.countryDao().getAllCountry();

        List<String> countriesName = new ArrayList<>();
        for (Country item: countries) {
            countriesName.add(item.name);
        }
        
        ArrayAdapter<String> countiesAdapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_item, countriesName);
        countiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.nameCountry.setAdapter(countiesAdapter);

        binding.nameCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Country country = countries.get((int) id);
                name_country = country.id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.insertBtn.setOnClickListener((v)->{

            String name = binding.name.getText().toString();
            String surname = binding.name.getText().toString();

            Actor item = new Actor(name, surname, name_country);

            database.actorDao().insert(item);

            getActivity().getSupportFragmentManager().popBackStack();
        });
    }
}