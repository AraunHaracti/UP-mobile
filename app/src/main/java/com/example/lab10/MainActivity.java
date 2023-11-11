package com.example.lab10;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab10.fragments.MainMenuFragment;
import com.example.lab10.fragments.containers.ListItemsCountryContainer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_fragment, new MainMenuFragment(), "list_fragment")
                .addToBackStack("list_fragment_transaction")
                .commit();
    }
}