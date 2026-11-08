package com.example.uclab4;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        if (!(manager.findFragmentById(R.id.fragment_container) instanceof RecipesFragment)) {
            manager.beginTransaction()
                    .replace(R.id.fragment_container, new RecipesFragment())
                    .commitNow();
        }

        Fragment details = manager.findFragmentById(R.id.details_container);
        if (findViewById(R.id.details_container) != null) {
            if (details == null) {
                manager.beginTransaction()
                        .replace(R.id.details_container, new IngredientsFragment())
                        .commitNow();
            }
        } else if (details != null) {
            manager.beginTransaction().remove(details).commitNow();
        }
    }
}
