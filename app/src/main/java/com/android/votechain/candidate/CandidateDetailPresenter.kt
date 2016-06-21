package com.android.votechain.candidate

import com.android.votechain.candidate.data.repository.ServerVoteRespository
import com.android.votechain.candidate.data.repository.VoteRepository
import com.android.votechain.candidate.domain.model.ResponseVote
import com.android.votechain.candidate.domain.model.Vote
import com.android.votechain.candidates.data.repository.CandidatesRepository
import com.android.votechain.candidates.data.repository.ServerCandidatesRespository
import com.android.votechain.candidates.domain.model.Candidate
import rx.Subscriber


class CandidateDetailPresenter(val view: CandidateDetailView.View) {

  lateinit var candidate: Candidate

  val repositoryCandidate by lazy {
    val repo: CandidatesRepository = ServerCandidatesRespository()
    repo
  }

  val repositoryVote by lazy {
    val repoVote: VoteRepository = ServerVoteRespository()
    repoVote
  }

  fun getCandidateData(idCandidate: String) {
    repositoryCandidate.getCandidate(idCandidate.toInt() - 1, object : Subscriber<Candidate>() {
      override fun onCompleted() {
      }

      override fun onNext(t: Candidate) {
        candidate = t
        view.showCandidateData(t)
      }

      override fun onError(e: Throwable?) {
      }
    })
  }

  fun textToSpeech() {
    var speech = candidate.name + ".    " + candidate.partido + ".    " + " Sus propuestas son: "
    speech += candidate.proposals.reduce { speech, proposal -> speech + ".     " + proposal }
    view.saySpeech(speech)
  }

  fun makeVote() {
    view.showLoadingVote()
    repositoryVote.setVote(Vote(candidate?.candidateId), object : Subscriber<ResponseVote>() {
      override fun onError(e: Throwable?) {
        view.hideLoadingVote()
      }

      override fun onCompleted() {
        view.hideLoadingVote()
      }

      override fun onNext(t: ResponseVote?) {
        view.successVote()
      }

    })
  }
}