package com.android.votechain.common.view

import android.support.annotation.AnimRes
import android.support.v4.app.Fragment

/**
 * 12/04/16.
 */
abstract class BaseFragActivity : BaseActivity() {


  override fun initView() {
    initializeFragment()
  }

  abstract fun getFragmentInstance(): Fragment

  abstract fun getIdFragmentContainer(): Int

  private fun initializeFragment() {
    val fragment = supportFragmentManager.findFragmentById(getIdFragmentContainer())
    if (fragment == null) {
      supportFragmentManager.beginTransaction().add(getIdFragmentContainer(),
          getFragmentInstance()).commit()
    }
  }

  fun addFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().replace(getIdFragmentContainer(),
        fragment).addToBackStack(
        "").commit()
  }

  fun addFragment(fragment: Fragment, @AnimRes enter: Int, @AnimRes exit: Int,
      @AnimRes popEnter: Int, @AnimRes popExit: Int) {

    supportFragmentManager.beginTransaction().setCustomAnimations(enter, exit, popEnter,
        popExit).replace(getIdFragmentContainer(), fragment).addToBackStack("").commit()
  }

  fun replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().replace(getIdFragmentContainer(), fragment).commit()
  }

  fun replaceFragment(fragment: Fragment, @AnimRes enter: Int, @AnimRes exit: Int) {
    supportFragmentManager.beginTransaction().setCustomAnimations(enter, exit).replace(
        getIdFragmentContainer(), fragment).commit()
  }

  fun popFragment() {
    supportFragmentManager.popBackStackImmediate()
  }
}