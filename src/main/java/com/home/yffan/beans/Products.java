package com.home.yffan.beans;

import javax.persistence.*;

/**
 * Created by Yffan on 08.04.2017.
 */

@Entity
@Table(name = "products")
@SuppressWarnings("serial")

public class Products {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 11, unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    public Products() {
    }

    public Products(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products)) return false;

        Products products = (Products) o;

        if (id != null ? !id.equals(products.id) : products.id != null) return false;
        return name != null ? name.equals(products.name) : products.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
