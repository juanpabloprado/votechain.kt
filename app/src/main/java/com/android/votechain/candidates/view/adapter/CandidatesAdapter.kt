package com.android.votechain.candidates.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.android.votechain.R
import com.android.votechain.candidates.domain.model.Candidate
import com.android.votechain.candidates.view.presenter.CandidatesPresenter
import com.android.votechain.common.view.inflate

/**
 * 21/06/2016.
 */
class CandidatesAdapter : RecyclerView.Adapter<CandidateViewHolder>() {

  private var presenter: CandidatesPresenter? = null


  private val candidates by lazy {
    mutableListOf<Candidate>()
  }


  override fun getItemCount(): Int {
    return candidates.size
  }

  override fun onBindViewHolder(holder: CandidateViewHolder?, position: Int) {
    holder?.bindItem(candidates[position])
  }

  fun setCandidates(candidates: List<Candidate>){
    this.candidates.addAll(candidates)
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CandidateViewHolder? {
    val viewItem = parent?.inflate(R.layout.item_candidate)
    return CandidateViewHolder(viewItem)
  }
}