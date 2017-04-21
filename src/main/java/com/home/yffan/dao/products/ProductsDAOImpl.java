package com.home.yffan.dao.products;

import com.home.yffan.beans.Products;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Yffan on 08.04.2017.
 */

@Repository("productsDao")
public class ProductsDAOImpl implements IProductsDAO {

    @Resource(name = "sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Products> getProducts() {
        List<Products> productsList = new ArrayList<Products>();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List products = session.createQuery("FROM Products").list();
            for (Iterator iterator = products.iterator(); iterator.hasNext();){
                Products product = (Products) iterator.next();
                productsList.add(product);
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return productsList;
    }
}
