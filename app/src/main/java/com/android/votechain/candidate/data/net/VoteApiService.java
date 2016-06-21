package com.android.votechain.candidate.data.net;

import com.android.votechain.candidate.domain.model.ResponseVote;
import com.android.votechain.candidate.domain.model.Vote;
import com.android.votechain.candidates.domain.model.Candidate;
import com.android.votechain.common.data.cloud.cloud.ClientConstants;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 16/06/2016.
 */
public interface VoteApiService {

  @GET(ClientConstants.EndPointApi.VOTE) Observable<ResponseVote> setVote(@Body Vote vote);
}
