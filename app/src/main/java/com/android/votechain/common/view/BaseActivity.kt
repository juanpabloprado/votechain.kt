package com.android.votechain.common.view

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.android.votechain.R

abstract class BaseActivity : AppCompatActivity() {

  private val toolbar: Toolbar? by lazy {
    findViewById(R.id.toolbar) as Toolbar
  };

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(getLayout())
    setupToolbar()
    setupActionBar(supportActionBar)
    initView()
    initView(savedInstanceState)

  }

  abstract fun getLayout(): Int

  open fun initView(savedInstanceState: Bundle?) {
  }

  open fun initView() {

  }

  fun setupActionBar(supportActionBar: ActionBar?) {

  }

  private fun setupToolbar() {
    setSupportActionBar(toolbar)
  }

}
