package com.example.architecturebase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.architecturebase.view.ContentFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val mainContentFragment = ContentFragment()
            supportFragmentManager.beginTransaction().apply {
                add(R.id.mainFragment, mainContentFragment)
                commit()
            }
        }
    }
}