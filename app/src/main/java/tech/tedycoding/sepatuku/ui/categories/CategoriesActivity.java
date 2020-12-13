package tech.tedycoding.sepatuku.ui.categories;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import tech.tedycoding.sepatuku.R;

public class CategoriesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        View toolbar = findViewById(R.id.toolbar);
        TextView titleBar = toolbar.findViewById(R.id.tv_title_bar);
        titleBar.setText("Categories");
    }
}
