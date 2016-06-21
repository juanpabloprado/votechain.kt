package com.android.votechain.candidate.data.net;

import com.android.votechain.candidate.domain.model.ResponseVote;
import com.android.votechain.candidate.domain.model.Vote;
import com.android.votechain.candidates.domain.model.Candidate;
import com.android.votechain.common.data.cloud.cloud.ApiClient;
import com.android.votechain.common.data.cloud.cloud.ClientConstants;
import java.util.List;
import rx.Observable;

/**
 * 16/06/2016.
 */
public class RestApiImpl extends ApiClient<VoteApiService> implements RestApi {

  @Override protected Class<VoteApiService> getApiService() {
    return VoteApiService.class;
  }

  @Override protected String getBaseURL() {
    return ClientConstants.BASE_URL_VOTE;
  }

  @Override public Observable<ResponseVote> setVote(Vote vote) {
    return apiService.setVote(vote);
  }
}
