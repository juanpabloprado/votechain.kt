package com.android.votechain.candidates.view.fragment

import android.os.Build
import android.os.Bundle
import android.support.annotation.AnimRes
import android.support.v7.widget.GridLayoutManager
import android.transition.TransitionInflater
import android.view.View
import android.widget.ImageView
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

  override fun showDetailCandidate(candidateId: String, name: String, imageView: ImageView) {

    addFragment(CandidateDetailFragment.newInstance(candidateId, name), R.anim.slide_in_left,
        R.anim.slide_out_left,
        R.anim.slide_in_right, R.anim.slide_out_right)


//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//      addFragmentTransition(CandidateDetailFragment.newInstance(candidateId, name),
//          R.anim.slide_in_left,
//          R.anim.slide_out_left,
//          R.anim.slide_in_right, R.anim.slide_out_right,imageView)
//    } else {
//      addFragment(CandidateDetailFragment.newInstance(candidateId, name), R.anim.slide_in_left,
//          R.anim.slide_out_left,
//          R.anim.slide_in_right, R.anim.slide_out_right)
//    }
  }

  private fun addFragmentTransition(newInstance: CandidateDetailFragment,@AnimRes enter: Int, @AnimRes exit: Int,
      @AnimRes popEnter: Int, @AnimRes popExit: Int, imageView: ImageView) {
    sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(
        R.transition.change_image_trans)
    newInstance.sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(
        R.transition.change_image_trans)


    fragmentManager.beginTransaction()
        .setCustomAnimations(enter, exit, popEnter,
            popExit)
        .replace(R.id.fragment_container, newInstance)
        .addToBackStack("")
//        .addSharedElement(imageView, getString(R.string.fragment_image_trans))
        .commit();


  }

}
