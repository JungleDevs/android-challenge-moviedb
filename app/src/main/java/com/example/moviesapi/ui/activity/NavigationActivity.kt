package com.example.moviesapi.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesapi.R

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MoviesAPI)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
    }
}