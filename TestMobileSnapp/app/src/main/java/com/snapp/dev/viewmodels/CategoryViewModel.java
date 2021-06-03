package com.snapp.dev.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.snapp.dev.retrofit.CategoriesCallback;
import com.snapp.dev.repositories.ListCategories;
import com.snapp.dev.retrofit.RetrofitBuilder;
import com.snapp.dev.models.Category;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryViewModel extends AndroidViewModel {

    private List<Category> ListContents = null;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
    }

    public void getAllCategories(final CategoriesCallback cb) {
        final MutableLiveData<List<Category>> list = new MutableLiveData<>();

        RetrofitBuilder.getCategoryProvider().getAllCategories().enqueue(new Callback<ListCategories>() {
            @Override
            public void onResponse(Call<ListCategories> call, Response<ListCategories> response) {
                ListContents = Objects.requireNonNull(response.body()).getListCategories();
                list.setValue(ListContents);
                cb.onDataGotList(list);
            }

            @Override
            public void onFailure(Call<ListCategories> call, Throwable t) {
            }
        });

    }
}

