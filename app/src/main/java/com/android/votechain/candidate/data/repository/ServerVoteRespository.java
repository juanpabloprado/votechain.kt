package com.android.votechain.candidate.data.repository;

import com.android.votechain.candidate.data.net.RestApi;
import com.android.votechain.candidate.data.net.RestApiImpl;
import com.android.votechain.candidate.domain.model.ResponseVote;
import com.android.votechain.candidate.domain.model.Vote;
import com.android.votechain.candidates.domain.model.Candidate;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 21/06/2016.
 */
public class ServerVoteRespository implements VoteRepository {

  private final RestApi restApi;

  public ServerVoteRespository() {
    restApi = new RestApiImpl();
  }

  @Override public void setVote(Vote vote,Subscriber<ResponseVote> UseCaseSubscriber) {
    restApi.setVote(vote).subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(UseCaseSubscriber);
  }
}
