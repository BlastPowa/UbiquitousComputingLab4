package com.example.uclab4;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class RecipeData {
    public static JSONArray loadRecipes(Context context) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                context.getAssets().open("recipes.json"), StandardCharsets.UTF_8))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line);
            }
            return new JSONArray(text.toString());
        } catch (IOException | JSONException e) {
            throw new IllegalStateException("Could not read recipes.json", e);
        }
    }
}
