package com.home.yffan.dao.recipe;

import com.home.yffan.beans.Recipe;

import java.util.List;

/**
 * Created by Yffan on 09.04.2017.
 */
public interface IRecipeDAO {

    public List<Recipe> getRecipes(List<Long> idList);

}
