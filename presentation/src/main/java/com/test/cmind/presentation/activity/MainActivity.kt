package com.test.cmind.presentation.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import com.test.cmind.presentation.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
                .add(R.id.containerView, Fragment(), "fragment")
                .commit()
    }
}