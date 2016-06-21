package com.android.votechain.candidates.view.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.android.votechain.R
import com.android.votechain.candidate.CandidateDetailFragment
import com.android.votechain.candidates.domain.model.Candidate
import com.android.votechain.candidates.view.adapter.CandidatesAdapter
import com.android.votechain.candidates.view.presenter.CandidatesPresenter
import com.android.votechain.candidates.view.viewmvp.CandidatesView
import com.android.votechain.common.view.BaseFragment
import com.android.votechain.view.ItemGridDecorator
import kotlinx.android.synthetic.main.fragment_candidates.*

class CandidatesFragment : BaseFragment(), CandidatesView {

  val presenter: CandidatesPresenter by lazy {
    CandidatesPresenter()
  };

//  private val myListCandidates by lazy {
//    listCandidates.setHasFixedSize(true)
//    listCandidates.layoutManager = GridLayoutManager(context, 2)
//    listCandidates.adapter = CandidatesAdapter(presenter)
//    listCandidates.addItemDecoration(ItemGridDecorator(context))
//    listCandidates
//  }


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
    initializePresenter()
    initializeList ()
    initializeMessageError()
    retainInstance = true
  }

  private fun initializePresenter() {
    presenter.view = this
    presenter.initialize()
  }

  private fun initializeList() {
    listCandidates.setHasFixedSize(true)
    listCandidates.layoutManager = GridLayoutManager(context, 2)
    listCandidates.adapter = CandidatesAdapter(presenter)
    listCandidates.addItemDecoration(ItemGridDecorator(context))
  }

  private fun initializeMessageError() {
    messageConnectionError.setOnClickListener { presenter.initialize() }
  }

  override fun showLoadingCandidates() {
    progressLoadingCandidates.visibility = View.VISIBLE
  }

  override fun hideLoadingCandidates() {
    progressLoadingCandidates.visibility = View.GONE

  }

  override fun showMessageErrorConnection() {
    messageConnectionError.visibility = View.VISIBLE
  }

  override fun hideMessageErrorConnection() {
    messageConnectionError.visibility = View.GONE
  }

  override fun showListCandidates(candidates: List<Candidate>) {
    (listCandidates.adapter as CandidatesAdapter).setCandidates(candidates)
  }

  override fun showDetailCandidate(candidateId: String, name: String) {
    addFragment(CandidateDetailFragment.newInstance(candidateId, name), R.anim.slide_in_left,
        R.anim.slide_out_left,
        R.anim.slide_in_right, R.anim.slide_out_right)

  }

}
