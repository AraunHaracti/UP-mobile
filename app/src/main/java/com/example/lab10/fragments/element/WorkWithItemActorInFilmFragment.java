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
import com.example.lab10.database.entities.Actor;
import com.example.lab10.database.entities.ActorInFilm;
import com.example.lab10.database.entities.Country;
import com.example.lab10.database.entities.Film;
import com.example.lab10.databinding.FragmentWorkWithItemActorBinding;
import com.example.lab10.databinding.FragmentWorkWithItemActorInFilmBinding;

import java.util.ArrayList;
import java.util.List;

public class WorkWithItemActorInFilmFragment extends WorkWithItemFragment {

    FragmentWorkWithItemActorInFilmBinding binding;

    public WorkWithItemActorInFilmFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWorkWithItemActorInFilmBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    List<Actor> actors = new ArrayList<>();
    List<Film> films = new ArrayList<>();
    int actor_id;
    int film_id;

    @Override
    protected void elementsInit(){
        Database db = Database.getDatabase(getContext());

        actors = db.actorDao().getAllActor();
        films = db.filmDao().getAllFilm();

        List<String> actorsName = new ArrayList<>();
        for (Actor item: actors) {
            actorsName.add(item.name + " " + item.surname);
        }

        List<String> filmsName = new ArrayList<>();
        for (Film item: films) {
            filmsName.add(item.name);
        }

        ArrayAdapter<String> actorsAdapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_item, actorsName);
        actorsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> filmsAdapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_item, filmsName);
        filmsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        binding.nameActor.setAdapter(actorsAdapter);
        binding.nameFilm.setAdapter(filmsAdapter);

        binding.nameActor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                actor_id = actors.get((int) id).id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        binding.nameFilm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                film_id = films.get((int) id).id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        binding.insertBtn.setOnClickListener((v)->{
            ActorInFilm item = new ActorInFilm(actor_id, film_id);

            database.actorInFilmDao().insert(item);

            getActivity().getSupportFragmentManager().popBackStack();
        });
    }
}