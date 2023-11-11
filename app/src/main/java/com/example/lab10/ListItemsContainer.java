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
import com.example.lab10.databinding.FragmentListItemsContainerBinding;

import java.util.List;

public class ListItemsContainer extends Fragment {

    FragmentListItemsContainerBinding binding;

    List<Country> countryList;

    Database db;

    public ListItemsContainer() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListItemsContainerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setItemsListInit();
        addItemBtnInit();
        longClickItemsListInit();
    }

    private void longClickItemsListInit()
    {
        binding.itemsList.setOnItemLongClickListener((parent, view, position, id) -> {
            Country selectedItem = (Country) parent.getItemAtPosition(position);

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment, new WorkWithItemFragment(selectedItem), "info_actor")
                    .addToBackStack(null).commit();

            return false;
        });
    }

    private void setItemsListInit() {
        db = Database.getDatabase(this.getContext());

        Thread th = new Thread(() -> {
            countryList = db.countryDao().getAllCountry();

            ItemListAdapter itemListAdapter = new ItemListAdapter(getContext(), R.layout.list_item_1, countryList);

            binding.itemsList.setAdapter(itemListAdapter);
        });
        th.start();
    }

    private void addItemBtnInit(){
        binding.addItemBtn.setOnClickListener((view)->{
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment, new WorkWithItemFragment(),"add_item")
                    .addToBackStack(null)
                    .commit();
        });
    }
}