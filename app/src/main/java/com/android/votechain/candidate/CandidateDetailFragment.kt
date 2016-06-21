package com.android.votechain.candidate

import com.android.votechain.R
import com.android.votechain.common.view.BaseFragment


class CandidateDetailFragment : BaseFragment() {


  companion object {
    fun newInstance(idCandidate: String?, name: String?): CandidateDetailFragment {
      return CandidateDetailFragment()
    }
  }


  override fun getFragmentLayout(): Int {
    return R.layout.fragment_candidate_detail
  }
}