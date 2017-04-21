package com.home.yffan.beans;

import javax.persistence.*;

/**
 * Created by Yffan on 10.04.2017.
 */

@Entity
@Table(name = "ingredients")
@SuppressWarnings("serial")

public class Ingredients {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 11, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipeID")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Products product;

    public Ingredients() {
    }

    public Ingredients(Recipe recipe, Products product) {
        this.recipe = recipe;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Ingredients)) return false;

        Ingredients that = (Ingredients) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (recipe != null ? !recipe.equals(that.recipe) : that.recipe != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (recipe != null ? recipe.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "id=" + id +
                ", recipe=" + recipe +
                ", product=" + product +
                '}';
    }
}
