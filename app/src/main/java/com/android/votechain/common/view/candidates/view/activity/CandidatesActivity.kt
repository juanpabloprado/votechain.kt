package com.android.votechain.common.view.candidates.view.activity

import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import com.android.votechain.R
import com.android.votechain.common.view.BaseFragActivity

class CandidatesActivity : BaseFragActivity() {

  override fun setupActionBar(supportActionBar: ActionBar?) {
    super.setupActionBar(supportActionBar)
  }

  override fun getLayout(): Int {
    return R.layout.activity_candidates
  }

  override fun getIdFragmentContainer(): Int {
    throw UnsupportedOperationException()
  }

  override fun getFragmentInstance(): Fragment {
    throw UnsupportedOperationException()
  }
}
