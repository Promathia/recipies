package com.home.yffan.beans;

import javax.persistence.*;

/**
 * Created by Yffan on 09.04.2017.
 */

@Entity
@Table(name = "recipe")
@SuppressWarnings("serial")

public class Recipe implements Comparable<Recipe> {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 11, unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Transient
    private int priorityNumber = 1;

    public Recipe() {
    }

    public Recipe(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void incrementPriorityNumber(){
        priorityNumber++;
    }

    public int getPriorityNumber() {
        return priorityNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;

        Recipe recipe = (Recipe) o;

        if (id != null ? !id.equals(recipe.id) : recipe.id != null) return false;
        if (name != null ? !name.equals(recipe.name) : recipe.name != null) return false;
        return description != null ? description.equals(recipe.description) : recipe.description == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priorityNumber=" + priorityNumber +
                '}';
    }

    @Override
    public int compareTo(Recipe recipe) {
        return recipe.getPriorityNumber() - priorityNumber;
    }
}
