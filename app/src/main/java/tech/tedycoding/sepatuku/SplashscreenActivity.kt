package tech.tedycoding.sepatuku

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import tech.tedycoding.sepatuku.ui.home.HomeActivity

class SplashscreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Handler().postDelayed(
            object : Runnable {
                override fun run() {
                    val goHome = Intent(this@SplashscreenActivity, HomeActivity::class.java)
                    startActivity(goHome)
                    finish()
                }
            }, 1000)
    }
}