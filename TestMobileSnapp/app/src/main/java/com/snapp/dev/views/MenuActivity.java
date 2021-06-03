package com.snapp.dev.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.snapp.dev.R;

import java.util.Objects;

/**
 * SHOWS THE MENU OF THE APPLICATION.
 */
public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView title = toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        title.setText(R.string.epsi);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        Button zone1 = findViewById(R.id.zone_1);
        zone1.setOnClickListener(v -> {
            Intent mainIntent = new Intent(MenuActivity.this, StudentInfoActivity.class);
            startActivity(mainIntent);
        });

        Button zone2 = findViewById(R.id.zone_2);
        zone2.setOnClickListener(v -> {
            Intent mainIntent = new Intent(MenuActivity.this, CategoriesActivity.class);
            startActivity(mainIntent);
        });
    }
}