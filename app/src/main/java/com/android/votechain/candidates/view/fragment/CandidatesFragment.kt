package com.android.votechain.candidates.view.fragment

import android.os.Bundle
import android.view.View
import com.android.votechain.R
import com.android.votechain.candidates.view.viewmvp.CandidatesView
import com.android.votechain.common.view.BaseFragment

class CandidatesFragment : BaseFragment(), CandidatesView {

  override fun getFragmentLayout(): Int {
    return R.layout.fragment_candidates
  }

  override fun initView(view: View?, savedInstanceState: Bundle?) {
    super.initView(view, savedInstanceState)
  }

  override fun showLoadingCandidates() {
    throw UnsupportedOperationException()
  }

  override fun hideLoadingCandidates() {
    throw UnsupportedOperationException()
  }

  override fun showMessageErrorConnection() {
    throw UnsupportedOperationException()
  }

  override fun hideMessageErrorConnection() {
    throw UnsupportedOperationException()
  }

  companion object {
    fun newInstance(): CandidatesFragment {
      return CandidatesFragment()
    }
  }

}
