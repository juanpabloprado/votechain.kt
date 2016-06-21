package com.android.votechain.common.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.android.votechain.R

abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initView(savedInstanceState)
        initView()
    }

    abstract fun getLayout(): Int

    open fun initView(savedInstanceState: Bundle?) {
        setupToolbar()
    }

    open fun initView() {

    }

    private fun setupToolbar() {
        val toolbar: Toolbar? = findViewById(R.id.toolbar) as Toolbar?

        if (toolbar != null)
            setSupportActionBar(toolbar)
    }

}
