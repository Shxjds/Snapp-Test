package com.snapp.dev.repositories;

import com.google.gson.annotations.SerializedName;
import com.snapp.dev.models.Category;

import java.util.List;

public class ListCategories {

    @SerializedName("items")
    private List<Category> categoriesList;

    public ListCategories(List<Category> categoriesList) {
        this.categoriesList = categoriesList;
    }

    public List<Category> getListCategories() {
        return categoriesList;
    }

    public void setListCategories(List<Category> categoriesList) {
        this.categoriesList = categoriesList;
    }
}
