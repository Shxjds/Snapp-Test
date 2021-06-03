package com.snapp.dev.retrofit;

import androidx.lifecycle.LiveData;

import com.snapp.dev.models.Product;

import java.util.List;

public interface ProductsCallback {

    void onDataGotList(LiveData<List<Product>> list);

}
