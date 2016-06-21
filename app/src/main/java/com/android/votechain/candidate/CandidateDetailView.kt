package com.android.votechain.candidate

import com.android.votechain.candidates.domain.model.Candidate


interface CandidateDetailView {

    interface View {
        fun showCandidateData(candidate: Candidate?)

    }

    interface UserActionListener {

    }
}