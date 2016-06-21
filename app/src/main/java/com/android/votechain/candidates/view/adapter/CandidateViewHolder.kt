package com.android.votechain.candidates.view.adapter

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.android.votechain.R
import com.android.votechain.candidates.domain.model.Candidate
import com.android.votechain.candidates.view.presenter.CandidatesPresenter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_candidate.view.*

/**
 * 21/06/2016.
 */
class CandidateViewHolder(var presenter: CandidatesPresenter?, view: View?) : RecyclerView.ViewHolder(view) {



  fun bindItem(candidate: Candidate) {
    itemView.labelNameCandidate.text = candidate.name
    itemView.labelPoliticParty.text = candidate.politicParty
    Glide.with(itemView.context).load(candidate.photoUrl).centerCrop().crossFade().into(
        itemView.imageCandidate)
    Glide.with(itemView.context).load(candidate.politicPartyImageUrl).centerCrop().crossFade().into(
        itemView.imagePoliticParty)
    itemView.setBackgroundColor(getColorPoliticParty(candidate.politicPartyId))

    itemView.setOnClickListener { presenter?.selectCandidate(candidate,itemView.imageCandidate) }

  }

  private fun getColorPoliticParty(candidateId: Int): Int {

    when (candidateId) {
      1 -> return ContextCompat.getColor(itemView.context, R.color.pan)
      2 -> return ContextCompat.getColor(itemView.context, R.color.pri)
      3 -> return ContextCompat.getColor(itemView.context, R.color.prd)
      4 -> return ContextCompat.getColor(itemView.context, R.color.na)
    }
    return 0
  }

}