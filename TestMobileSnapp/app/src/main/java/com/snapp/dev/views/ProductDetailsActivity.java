package com.snapp.dev.views;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.snapp.dev.R;
import com.squareup.picasso.Picasso;

import java.util.Objects;

/**
 * SHOWS DETAILS ABOUT A SPECIFIC PRODUCT.
 */
public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView title = toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        title.setText(getIntent().getStringExtra("productName"));
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);
        toolbar.setNavigationOnClickListener(v -> finish());

        ImageView image = findViewById(R.id.image);
        Picasso.get().load(getIntent().getStringExtra("productImage")).fit().centerCrop().into(image);

        TextView description = findViewById(R.id.description);
        description.setText(getIntent().getStringExtra("productDescription"));
    }
}