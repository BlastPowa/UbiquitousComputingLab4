package com.example.uclab4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;

public class RecipesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recipes, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        JSONArray recipes = RecipeData.loadRecipes(getActivity());
        ArrayList<String> names = new ArrayList<>();
        try {
            for (int i = 0; i < recipes.length(); i++) {
                names.add(recipes.getJSONObject(i).getString("name"));
            }
        } catch (JSONException e) {
            throw new IllegalStateException("Could not read recipe names", e);
        }

        ListView recipesList = view.findViewById(R.id.recipesList);
        recipesList.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, names));
    }
}
