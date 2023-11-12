package com.example.lab10.fragments.element;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab10.database.Database;

public class WorkWithItemFragment extends Fragment {

    protected Database database = Database.getDatabase(getContext());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        elementsInit();
    }

    protected void elementsInit(){}
}
