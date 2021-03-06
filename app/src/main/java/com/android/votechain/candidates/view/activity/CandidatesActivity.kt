package com.android.votechain.candidates.view.activity

import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.view.MenuItem
import com.android.votechain.R
import com.android.votechain.candidates.view.fragment.CandidatesFragment
import com.android.votechain.common.view.BaseFragActivity

class CandidatesActivity : BaseFragActivity() {

  override fun setupActionBar(supportActionBar: ActionBar?) {
    super.setupActionBar(supportActionBar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
  }

  override fun getLayout(): Int {
    return R.layout.activity_candidates
  }

  override fun getIdFragmentContainer(): Int {
    return R.id.fragment_container
  }

  override fun getFragmentInstance(): Fragment {
    return CandidatesFragment.newInstance()
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {

    if (item?.itemId == android.R.id.home) {
      onBackPressed()
    }
    return super.onOptionsItemSelected(item)


  }

  override fun onBackPressed() {
    if (supportFragmentManager.backStackEntryCount > 0) {
      supportFragmentManager.popBackStack()
    } else {
      super.onBackPressed()
    }
  }

}
