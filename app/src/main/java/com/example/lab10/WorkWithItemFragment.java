package com.example.lab10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab10.database.Database;
import com.example.lab10.database.entities.Country;
import com.example.lab10.databinding.FragmentWorkWithItemBinding;

public class WorkWithItemFragment extends Fragment {

    FragmentWorkWithItemBinding binding;

    Country country;

    WorkWithItemEnum workWithItemEnum;

    Database database;

    public WorkWithItemFragment() {
        workWithItemEnum = WorkWithItemEnum.Insert;
    }

    public WorkWithItemFragment(Country country) {
        workWithItemEnum = WorkWithItemEnum.Update;
        this.country = country;
    }

    private void changeVisibility()
    {
        switch (workWithItemEnum){
            default:
            case Insert:
                binding.insertBtn.setVisibility(View.VISIBLE);
                break;
            case Update:
                binding.updateBtn.setVisibility(View.VISIBLE);
                binding.name.setText(country.name);
//                break;
            case Delete:
                binding.deleteBtn.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = Database.getDatabase(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWorkWithItemBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        changeVisibility();

        initBtns();
    }

    private void initBtns()
    {
        insertBtnInit();
        updateBtnInit();
        deleteBtnInit();
    }

    private void insertBtnInit(){
        binding.insertBtn.setOnClickListener((v)->{
            String name = binding.name.getText().toString();

            Country country = new Country(name);

            database.countryDao().insert(country);

            getActivity().getSupportFragmentManager().popBackStack();
        });
    }

    private void updateBtnInit()
    {
        binding.updateBtn.setOnClickListener((v)->{
            String name = binding.name.getText().toString();

            country.name = name;

            database.countryDao().update(country);

            getActivity().getSupportFragmentManager().popBackStack();
        });
    }

    private void deleteBtnInit(){
        binding.deleteBtn.setOnClickListener((v)->{

            database.countryDao().delete(country);

            getActivity().getSupportFragmentManager().popBackStack();
        });
    }
}