package com.home.yffan.json;

import com.home.yffan.beans.Recipe;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Created by Yffan on 19.04.2017.
 */

public class RecipeJSON {

    private enum Fields {
        ID, NAME, DESCRIPTION
    }

    public static String getRecipesJSON( List<Recipe> list) {
        JSONArray array = new JSONArray();
        for (Recipe recipe : list) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(Fields.ID.name().toLowerCase(), recipe.getId());
            jsonObject.put(Fields.NAME.name().toLowerCase(), recipe.getName());
            jsonObject.put(Fields.DESCRIPTION.name().toLowerCase(), recipe.getDescription());
            array.add(jsonObject);
        }
        return array.toJSONString();
    }
}
