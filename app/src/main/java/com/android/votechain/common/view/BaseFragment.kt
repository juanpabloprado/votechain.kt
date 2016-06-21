package com.android.votechain.common.view

import android.content.Intent
import android.os.Bundle
import android.support.annotation.AnimRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.toolbar.*

/**
 * 27/11/15.
 *
 *
 * *
 *
 *
 * A fragment like an activity only will execute operations that affect the UI.
 * These operations are defined by a view model and are triggered by its presenter.
 *
 */

abstract class BaseFragment : Fragment() {


  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    return inflater?.inflate(getFragmentLayout(), container, false)
  }

  abstract   fun getFragmentLayout(): Int

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupActionBar(getSupportActionBar())
  }

  private fun getSupportActionBar(): ActionBar? {
    return (activity as BaseActivity).supportActionBar
  }

  open fun setupActionBar(actionBar: ActionBar?) {

  }

  open fun enableOptionsMenu() {
    setHasOptionsMenu(true)
  }

  /**
   * Replace all the annotated fields with ButterKnife annotations with the proper value
   */

  fun setResultAactivity(resultCode: Int, data: Intent) {
    activity.setResult(resultCode, data)
  }

  fun finishActivity() {
    activity.finish()
  }

  fun addFragment(fragment: Fragment) {
    (activity as BaseFragActivity).addFragment(fragment)
  }

  fun addFragment(fragment: Fragment, @AnimRes enter: Int, @AnimRes exit: Int,
      @AnimRes popEnter: Int, @AnimRes popExit: Int) {
    (activity as BaseFragActivity).addFragment(fragment, enter, exit, popEnter, popExit)
  }

  fun replaceFragment(fragment: Fragment) {
    (activity as BaseFragActivity).replaceFragment(fragment)
  }

  fun replaceFragment(fragment: Fragment, @AnimRes enter: Int, @AnimRes exit: Int) {
    (activity as BaseFragActivity).replaceFragment(fragment, enter, exit)
  }

  fun popConcurrentFragment() {
    (activity as BaseFragActivity).popFragment()
  }

   fun getToolbar() : Toolbar? {
    return (activity as BaseActivity).toolbar;
  }

}

