package com.android.votechain.candidates.data.net;

import com.android.votechain.candidates.domain.model.Candidate;
import com.android.votechain.common.data.cloud.cloud.ClientConstants;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 16/06/2016.
 */
public interface CandidateApiService {

  @GET(ClientConstants.EndPointApi.CANDIDATES) Observable<List<Candidate>> getCandidates();

  @GET(ClientConstants.EndPointApi.CANDIDATE) Observable<Candidate> getCandidate(
      @Path(ClientConstants.Path.ID_CONDIDATE) int idCandidate);
}
