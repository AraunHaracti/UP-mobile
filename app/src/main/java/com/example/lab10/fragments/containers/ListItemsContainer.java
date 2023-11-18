package com.example.lab10.fragments.containers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab10.R;
import com.example.lab10.database.Database;
import com.example.lab10.databinding.FragmentListItemsContainerBinding;
import com.example.lab10.fragments.element.WorkWithItemFragment;

public abstract class ListItemsContainer extends Fragment {

    public FragmentListItemsContainerBinding binding;

    Database db;

    public ListItemsContainer() {}
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

        setBehavior();
    }

    private void setBehavior(){
        db = Database.getDatabase(getContext());

        setItemsListInit();

        addItemBtnInit();
    }

    private void setItemsListInit() {
        setAdapter();
    }

    private void addItemBtnInit(){
        WorkWithItemFragment workWithItemFragment = getWorkWithItemListFragment();

        if (workWithItemFragment == null) return;

        binding.addItemBtn.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, workWithItemFragment, "add_item")
                    .addToBackStack("list_fragment_transaction")
                    .commit();
        });
    }

    protected abstract void setAdapter();
    protected abstract WorkWithItemFragment getWorkWithItemListFragment();
}