package com.home.yffan.service.recipe;

import com.home.yffan.beans.Recipe;
import com.home.yffan.dao.recipe.IRecipeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yffan on 09.04.2017.
 */

@Service("recipeService")
public class RecipeServiceImpl implements IRecipeService {

    @Autowired
    private IRecipeDAO recipeDAO;

    @Override
    public List<Recipe> getRecipes(List<Long> idList) {
        return recipeDAO.getRecipes(idList);
    }
}
