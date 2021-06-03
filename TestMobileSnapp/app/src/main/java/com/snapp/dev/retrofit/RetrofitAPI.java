package com.snapp.dev.retrofit;

import com.snapp.dev.repositories.ListCategories;
import com.snapp.dev.repositories.ListProducts;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitAPI {

    @GET("categories.json")
    Call<ListCategories> getAllCategories();

    @GET
    Call<ListProducts> getAllProducts(@Url String productName);
}
