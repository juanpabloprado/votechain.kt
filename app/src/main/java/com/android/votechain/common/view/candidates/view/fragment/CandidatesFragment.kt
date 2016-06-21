package com.android.votechain.common.view.candidates.view.fragment

import android.support.v4.app.Fragment
import com.android.votechain.common.view.BaseFragment

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CandidatesFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CandidatesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CandidatesFragment : BaseFragment() {
  companion object {
    fun newInstance(): CandidatesFragment {
      return CandidatesFragment()
    }
  }
}
