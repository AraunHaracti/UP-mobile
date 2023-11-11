package com.example.lab10.fragments.element;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;

import com.example.lab10.database.Database;
import com.example.lab10.database.entities.Country;
import com.example.lab10.databinding.FragmentWorkWithItemBinding;

public class WorkWithCountryItemFragment extends WorkWithItemListFragment {

    FragmentWorkWithItemBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWorkWithItemBinding.inflate(inflater, container, false);
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