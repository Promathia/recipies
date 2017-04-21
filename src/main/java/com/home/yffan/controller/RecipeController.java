package com.home.yffan.controller;

import com.home.yffan.beans.Recipe;
import com.home.yffan.json.RecipeJSON;
import com.home.yffan.service.recipe.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yffan on 16.04.2017.
 */

@Controller
public class RecipeController {

    @Autowired
    private IRecipeService recipeService;

    @RequestMapping(value = "/receiveRecipe", method = RequestMethod.GET, produces = {"text/html; charset=UTF-8"})
    public @ResponseBody String getRecipes(@RequestParam("products") List<Long> listId) {
        List<Recipe> list = recipeService.getRecipes(listId);
        return RecipeJSON.getRecipesJSON(list);
    }
}
