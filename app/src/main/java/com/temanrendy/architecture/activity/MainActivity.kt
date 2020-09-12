package com.temanrendy.architecture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.temanrendy.architecture.activity.PostActivity
import com.temanrendy.architecture.activity.UserActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnUser.setOnClickListener {
            Intent(this@MainActivity, UserActivity::class.java).also {
                startActivity(it)
            }
        }
        btnPost.setOnClickListener {
            Intent(this@MainActivity, PostActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}