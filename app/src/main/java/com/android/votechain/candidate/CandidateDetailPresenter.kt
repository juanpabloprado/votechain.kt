package com.android.votechain.candidate

import com.android.votechain.candidates.data.repository.CandidatesRepository
import com.android.votechain.candidates.data.repository.ServerCandidatesRespository
import com.android.votechain.candidates.domain.model.Candidate
import rx.Subscriber


class CandidateDetailPresenter(val view: CandidateDetailView.View) {

    lateinit var candidate: Candidate

    val repository by lazy {
        val repo: CandidatesRepository = ServerCandidatesRespository()
        repo
    }

    fun getCandidateData(idCandidate: String) {
        repository.getCandidate(idCandidate.toInt() - 1, object : Subscriber<Candidate>() {
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
}