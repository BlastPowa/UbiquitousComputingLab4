package com.example.uclab4;

import android.os.Bundle;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class DetailsActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        FragmentManager manager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            manager.beginTransaction()
                    .replace(R.id.details_container, new IngredientsFragment())
                    .addToBackStack(null)
                    .commit();
        }

        Fragment recipes = manager.findFragmentById(R.id.fragment_container);
        if (findViewById(R.id.fragment_container) != null) {
            if (recipes == null) {
                manager.beginTransaction()
                        .replace(R.id.fragment_container, new RecipesFragment())
                        .commitNow();
            }
        } else if (recipes != null) {
            manager.beginTransaction().remove(recipes).commitNow();
        }

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                getSupportFragmentManager().popBackStackImmediate();
                finish();
            }
        });
    }
}
