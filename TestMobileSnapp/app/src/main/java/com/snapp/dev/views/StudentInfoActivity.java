package com.snapp.dev.views;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.snapp.dev.R;

import java.util.Objects;

/**
 * SHOWS INFORMATION OF A STUDENT.
 */
public class StudentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView title = toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        title.setText(R.string.name);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);
        toolbar.setNavigationOnClickListener(v -> finish());

        TextView portfolio = findViewById(R.id.portfolio);
        portfolio.setMovementMethod(LinkMovementMethod.getInstance());
    }
}