package com.example.uclab4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import org.json.JSONException;
import org.json.JSONObject;

public class IngredientsFragment extends Fragment {
    private int recipePosition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ingredients, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = getArguments() == null ? 0 : getArguments().getInt("recipe");
        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("recipe");
        }
        showRecipe(position);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("recipe", recipePosition);
    }

    public void showRecipe(int position) {
        recipePosition = position;
        try {
            JSONObject recipe = RecipeData.loadRecipes(getActivity()).getJSONObject(position);
            TextView nameText = getView().findViewById(R.id.nameText);
            TextView ingredientsText = getView().findViewById(R.id.ingredientsText);
            TextView methodText = getView().findViewById(R.id.methodText);
            nameText.setText(recipe.getString("name"));
            ingredientsText.setText(getString(R.string.ingredients, recipe.getString("ingredients")));
            methodText.setText(getString(R.string.method, recipe.getString("method")));
        } catch (JSONException e) {
            throw new IllegalStateException("Could not read recipe details", e);
        }
    }
}
