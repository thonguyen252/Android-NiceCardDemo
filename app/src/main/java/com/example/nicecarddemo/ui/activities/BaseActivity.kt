package com.example.nicecarddemo.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Nguyen on 3/27/2019.
 *
 * This BaseActivity contains the common functions which can be shared between activities.
 * All of the activities in this app should be extended from this class.
 */
abstract class BaseActivity : AppCompatActivity() {

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResourceId())
        initializeViewModel()
        initializeView(savedInstanceState)
    }

    protected fun initializeViewModel() {}

    protected fun initializeView(savedInstanceState: Bundle?) {}

    abstract fun getLayoutResourceId(): Int
}