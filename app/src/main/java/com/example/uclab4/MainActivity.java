package com.example.uclab4;

import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import org.json.JSONArray;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONArray recipes = RecipeData.loadRecipes(this);
        TextView recipesText = findViewById(R.id.recipesText);
        recipesText.setText(getString(R.string.recipes_loaded, recipes.length()));
    }
}
