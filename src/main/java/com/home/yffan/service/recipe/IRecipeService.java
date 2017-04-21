package com.home.yffan.service.recipe;

import com.home.yffan.beans.Recipe;

import java.util.List;

/**
 * Created by Yffan on 09.04.2017.
 */

public interface IRecipeService {

    public List<Recipe> getRecipes(List<Long> idList);

}
