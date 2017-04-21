package com.home.yffan.service.products;

import com.home.yffan.beans.Products;
import com.home.yffan.dao.products.IProductsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yffan on 08.04.2017.
 */

@Service("productsService")
public class ProductsServiceImpl implements IProductsService {

    @Autowired
    private IProductsDAO productsDAO;

    @Override
    public List<Products> getProducts() {
        return productsDAO.getProducts();
    }
}
