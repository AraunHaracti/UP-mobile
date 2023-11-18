package com.example.lab10.fragments.element;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.lab10.R;
import com.example.lab10.database.Database;
import com.example.lab10.database.entities.Country;
import com.example.lab10.database.entities.Film;
import com.example.lab10.database.entities.Genre;
import com.example.lab10.databinding.FragmentWorkWithItemCountryBinding;
import com.example.lab10.databinding.FragmentWorkWithItemFilmBinding;

import java.util.ArrayList;
import java.util.List;

public class WorkWithItemFilmFragment extends WorkWithItemFragment {

    FragmentWorkWithItemFilmBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWorkWithItemFilmBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    List<Country> countries;
    List<Genre> genres;
    int country_id;
    int genre_id;

    @Override
    protected void elementsInit(){
        Database db = Database.getDatabase(getContext());

        countries = db.countryDao().getAllCountry();
        genres = db.genreDao().getAllGenre();

        List<String> countriesName = new ArrayList<>();
        for (Country item: countries) {
            countriesName.add(item.name);
        }
        List<String> genresName = new ArrayList<>();
        for (Genre item: genres) {
            genresName.add(item.name);
        }

        ArrayAdapter<String> countiesAdapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_item, countriesName);
        ArrayAdapter<String> genresAdapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_item, genresName);

        countiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genresAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.nameCountry.setAdapter(countiesAdapter);
        binding.nameGenre.setAdapter(genresAdapter);

        binding.nameCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country_id = countries.get((int) id).id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.nameGenre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                genre_id = genres.get((int) id).id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.insertBtn.setOnClickListener((v)->{
            String name = binding.name.getText().toString();

            Film item = new Film(name, genre_id, country_id);

            database.filmDao().insert(item);

            getActivity().getSupportFragmentManager().popBackStack();
        });
    }
}