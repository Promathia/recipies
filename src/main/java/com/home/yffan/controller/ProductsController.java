package com.home.yffan.controller;

import com.home.yffan.service.products.IProductsService;
import com.home.yffan.service.recipe.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Yffan on 08.04.2017.
 */

@Controller
@RequestMapping("products.html")
public class ProductsController {

    @Autowired
    private IProductsService productsService;

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(Map model) {
        model.put("products", productsService.getProducts());
        return "products";
    }

    /*@RequestMapping(value = "/receiveRecipes", method = RequestMethod.GET)
    public @ResponseBody String getRecipes( @RequestBody List<Integer> idList) {

        //String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
        //System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
        return result;
    }*/

}
