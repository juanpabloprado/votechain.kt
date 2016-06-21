package com.android.votechain.candidate.data.net;

import com.android.votechain.candidate.domain.model.ResponseVote;
import com.android.votechain.candidate.domain.model.Vote;
import com.android.votechain.candidates.domain.model.Candidate;
import java.util.List;
import rx.Observable;

/**
 * 16/06/2016.
 */
public interface RestApi {

  Observable<ResponseVote> setVote(Vote vote);

}
