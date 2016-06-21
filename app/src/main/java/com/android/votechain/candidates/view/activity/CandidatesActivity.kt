package com.android.votechain.candidates.view.activity

import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import com.android.votechain.R
import com.android.votechain.common.view.BaseFragActivity
import com.android.votechain.candidates.view.fragment.CandidatesFragment

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
}
