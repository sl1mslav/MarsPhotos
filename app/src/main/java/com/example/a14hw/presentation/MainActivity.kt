package com.example.a14hw.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a14hw.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}