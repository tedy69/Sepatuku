package tech.tedycoding.sepatuku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import tech.tedycoding.sepatuku.ui.home.HomeActivity;


public class SplashscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goHome = new Intent(SplashscreenActivity.this, HomeActivity.class);
                startActivity(goHome);
                finish();
            }
        }, 1000);
    }
}
