package com.android.votechain.common.view.candidates.view.fragment

import android.os.Bundle
import android.view.View
import com.android.votechain.R
import com.android.votechain.common.view.BaseFragment

class CandidatesFragment : BaseFragment() {

  companion object {
    fun newInstance(): CandidatesFragment {
      return CandidatesFragment()
    }
  }

  override fun getFragmentLayout(): Int {
    return R.layout.fragment_candidates
  }

  override fun initView(view: View?, savedInstanceState: Bundle?) {
    super.initView(view, savedInstanceState)
  }

}
