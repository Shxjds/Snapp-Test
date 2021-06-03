package com.snapp.dev.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.snapp.dev.models.Category;
import com.snapp.dev.viewmodels.CategoryViewModel;
import com.snapp.dev.R;
import com.snapp.dev.adapters.RecyclerViewCategoryAdapter;

import java.util.List;
import java.util.Objects;

/**
 * SHOWS A LIST OF CATEGORIES.
 */
public class CategoriesActivity extends AppCompatActivity {

    private CategoryViewModel categoryViewModel;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        categoryViewModel = new CategoryViewModel(getApplication());
        progressBar = findViewById(R.id.loading);

        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView title = toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        title.setText(R.string.categories);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);
        toolbar.setNavigationOnClickListener(v -> finish());

        callApi();
    }

    /**
     * Allows you to retrieve categories from the API and add them to the RecyclerView.
     */
    private void callApi() {
        categoryViewModel.getAllCategories(list -> {
            progressBar.setVisibility(View.GONE);
            setUpRecyclerView(list.getValue());
        });
    }

    /**
     * Displays a recyclerview containing our list of categories.
     *
     * @param categoryList List of retrieved categories from WS.
     */
    private void setUpRecyclerView(List<Category> categoryList) {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewCategoryAdapter sAdapter = new RecyclerViewCategoryAdapter(categoryList);
        sAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(sAdapter);

        sAdapter.setOnItemClickListener(position -> {
            Intent in = new Intent(CategoriesActivity.this, ProductsActivity.class);
            in.putExtra("categoryUrl", categoryList.get(position).getProducts_url());
            in.putExtra("categoryName", categoryList.get(position).getTitle());
            startActivity(in);
        });
    }
}