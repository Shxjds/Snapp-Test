package com.snapp.dev.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.snapp.dev.repositories.ListProducts;
import com.snapp.dev.retrofit.ProductsCallback;
import com.snapp.dev.retrofit.RetrofitBuilder;
import com.snapp.dev.models.Product;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductViewModel extends AndroidViewModel {

    private List<Product> ListContents = null;

    public ProductViewModel(@NonNull Application application) {
        super(application);
    }

    public void getAllProducts(final ProductsCallback cb, final String productName) {
        final MutableLiveData<List<Product>> list = new MutableLiveData<>();

        RetrofitBuilder.getProductProvider().getAllProducts(productName).enqueue(new Callback<ListProducts>() {
            @Override
            public void onResponse(Call<ListProducts> call, Response<ListProducts> response) {
                ListContents = Objects.requireNonNull(response.body()).getListProducts();
                list.setValue(ListContents);
                cb.onDataGotList(list);
            }

            @Override
            public void onFailure(Call<ListProducts> call, Throwable t) {
            }
        });

    }
}

