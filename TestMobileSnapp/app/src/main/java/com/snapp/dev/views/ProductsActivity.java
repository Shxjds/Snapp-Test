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

import com.snapp.dev.models.Product;
import com.snapp.dev.viewmodels.ProductViewModel;
import com.snapp.dev.R;
import com.snapp.dev.adapters.RecyclerViewProductAdapter;

import java.util.List;
import java.util.Objects;

/**
 * SHOWS A LIST OF PRODUCTS.
 */
public class ProductsActivity extends AppCompatActivity {

    private ProductViewModel productViewModel;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        productViewModel = new ProductViewModel(getApplication());
        progressBar = findViewById(R.id.loading);

        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView title = toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        title.setText(getIntent().getStringExtra("categoryName"));
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);
        toolbar.setNavigationOnClickListener(v -> finish());

        callApi();
    }

    /**
     * Allows you to retrieve products from the API and add them to the RecyclerView.
     */
    private void callApi() {
        productViewModel.getAllProducts(list -> {
            progressBar.setVisibility(View.GONE);
            ProductsActivity.this.setUpRecyclerView(list.getValue());
        }, getIntent().getStringExtra("categoryUrl"));
    }

    /**
     * Displays a recyclerview containing our list of products.
     *
     * @param productList List of retrieved products from WS.
     */
    private void setUpRecyclerView(List<Product> productList) {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewProductAdapter sAdapter = new RecyclerViewProductAdapter(productList);
        sAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(sAdapter);

        sAdapter.setOnItemClickListener(position -> {
            Intent in = new Intent(ProductsActivity.this, ProductDetailsActivity.class);
            in.putExtra("productName", productList.get(position).getName());
            in.putExtra("productDescription", productList.get(position).getDescription());
            in.putExtra("productImage", productList.get(position).getPicture_url());
            startActivity(in);
        });
    }
}