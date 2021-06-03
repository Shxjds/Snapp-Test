package com.snapp.dev.repositories;

import com.google.gson.annotations.SerializedName;
import com.snapp.dev.models.Product;

import java.util.List;

public class ListProducts {

    @SerializedName("items")
    private List<Product> productsList;

    public ListProducts(List<Product> productsList) {
        this.productsList = productsList;
    }

    public List<Product> getListProducts() {
        return productsList;
    }

    public void setListProducts(List<Product> productsList) {
        this.productsList = productsList;
    }
}
