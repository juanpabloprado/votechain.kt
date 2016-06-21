package com.android.votechain.candidate

import com.android.votechain.candidates.domain.model.Candidate


interface CandidateDetailView {

  interface View {
    fun showCandidateData(candidate: Candidate?)

    fun saySpeech(speech: String?)

    fun showLoadingVote()

    fun hideLoadingVote()

    fun successVote()

  }

  interface UserActionListener {

  }
}