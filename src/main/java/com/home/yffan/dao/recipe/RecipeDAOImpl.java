package com.home.yffan.dao.recipe;

import com.home.yffan.beans.Recipe;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Yffan on 09.04.2017.
 */

@Repository("recipeDAO")
public class RecipeDAOImpl implements IRecipeDAO {

    @Resource(name = "sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Recipe> getRecipes(List<Long> idList) {
        final String SQL_QUERY = "SELECT recipe FROM Recipe recipe, Ingredients ingr INNER JOIN ingr.recipe WHERE ingr.product.id IN (:ids)";
        List<Recipe> recipesList = new ArrayList<Recipe>();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery(SQL_QUERY);
            query.setParameterList("ids", idList);
            List recipes = query.list();
            for (Iterator iterator = recipes.iterator(); iterator.hasNext();){
                Recipe recipe = (Recipe) iterator.next();
                int index = Collections.binarySearch(recipesList, recipe);
                if (index >= 0) {
                    recipesList.get(index).incrementPriorityNumber();
                } else {
                    recipesList.add(-index - 1, recipe);
                }
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return recipesList;
    }
}