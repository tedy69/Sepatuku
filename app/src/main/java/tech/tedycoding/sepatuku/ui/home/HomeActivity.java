package tech.tedycoding.sepatuku.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import tech.tedycoding.sepatuku.R;
import tech.tedycoding.sepatuku.ui.cart.CartActivity;
import tech.tedycoding.sepatuku.ui.categories.CategoriesActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        View viewToolbar = findViewById(R.id.layout_toolbar);
        ImageView menuCart = viewToolbar.findViewById(R.id.menu_cart);
        ImageView menuFilter = viewToolbar.findViewById(R.id.menu_filter);

        menuCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goCart = new Intent(HomeActivity.this, CartActivity.class);
                startActivity(goCart);
            }
        });

        menuFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goCart = new Intent(HomeActivity.this, CategoriesActivity.class);
                startActivity(goCart);
            }
        });
    }
}