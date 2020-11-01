package tech.tedycoding.sepatuku.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.layout_toolbar_home.*
import tech.tedycoding.sepatuku.R
import tech.tedycoding.sepatuku.ui.cart.CartActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        menu_cart.setOnClickListener {
            val goCart = Intent(this@HomeActivity, CartActivity::class.java)
            startActivity(goCart)
        }

//        menu_filter.setOnClickListener {
//            val goCart = Intent(this@HomeActivity, CategoriesActivity::class.java)
//            startActivity(goCart)
//        }
    }

}