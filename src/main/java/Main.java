import com.home.yffan.beans.Products;
import com.home.yffan.beans.Recipe;
import com.home.yffan.dao.recipe.IRecipeDAO;
import com.home.yffan.json.RecipeJSON;
import com.home.yffan.service.products.IProductsService;
import com.home.yffan.service.products.ProductsServiceImpl;
import com.home.yffan.service.recipe.IRecipeService;
import com.home.yffan.service.recipe.RecipeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Yffan on 29.03.2017.
 */

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");

        IRecipeService clientDAO = (RecipeServiceImpl) context.getBean("recipeService");

        List<Long> listID = new ArrayList<Long>();
        listID.add(1L);
        listID.add(4L);

        List<Recipe> list = clientDAO.getRecipes(listID);
        Collections.sort(list);
        System.out.println(RecipeJSON.getRecipesJSON(list));
    }

}
