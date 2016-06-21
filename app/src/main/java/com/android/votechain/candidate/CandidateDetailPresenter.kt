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

  var candidate: Candidate? = null
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

      override fun onNext(t: Candidate?) {
        candidate = t
        view.showCandidateData(t)
      }

      override fun onError(e: Throwable?) {
      }
    })
  }

  fun makeVote() {
    repositoryVote.setVote(Vote(candidate?.candidateId), object : Subscriber<ResponseVote>() {
      override fun onError(e: Throwable?) {
        throw UnsupportedOperationException()
      }

      override fun onCompleted() {
        throw UnsupportedOperationException()
      }

      override fun onNext(t: ResponseVote?) {
        throw UnsupportedOperationException()
      }

    })
  }

}