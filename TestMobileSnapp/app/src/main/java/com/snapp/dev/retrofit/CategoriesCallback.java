package com.snapp.dev.retrofit;

import androidx.lifecycle.LiveData;

import com.snapp.dev.models.Category;

import java.util.List;

public interface CategoriesCallback {

    void onDataGotList(LiveData<List<Category>> list);

}
