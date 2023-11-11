package com.example.lab10.fragments.containers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab10.adapters.CountryItemsListAdapter;
import com.example.lab10.R;
import com.example.lab10.database.Database;
import com.example.lab10.databinding.FragmentListItemsContainerBinding;
import com.example.lab10.fragments.element.WorkWithCountryItemFragment;
import com.example.lab10.fragments.element.WorkWithItemListFragment;

public class ListItemsContainer extends Fragment {

    FragmentListItemsContainerBinding binding;

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

        setItemsListInit();
        addItemBtnInit();
    }

    private void setItemsListInit() {
        Thread th = new Thread(setThread());
        th.start();
    }

    protected Runnable setThread()
    {
        Database db = Database.getDatabase(this.getContext());

        Runnable th = () -> {
            binding.itemsList.setAdapter(new CountryItemsListAdapter(getContext(), R.layout.list_item_1, db.countryDao().getAllCountry()));
        };

        return th;
    }

    protected void addItemBtnInit(){ }
}