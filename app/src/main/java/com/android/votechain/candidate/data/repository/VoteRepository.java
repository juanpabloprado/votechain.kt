package com.android.votechain.candidate.data.repository;

import com.android.votechain.candidate.domain.model.ResponseVote;
import com.android.votechain.candidate.domain.model.Vote;
import com.android.votechain.candidates.domain.model.Candidate;
import java.util.List;
import rx.Subscriber;

/**
 * 21/06/2016.
 */
public interface VoteRepository {

  void setVote(Vote vote,Subscriber<ResponseVote> UseCaseSubscriber);

}
