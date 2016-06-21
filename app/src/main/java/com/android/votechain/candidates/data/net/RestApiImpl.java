package com.android.votechain.candidates.data.net;

import com.android.votechain.candidates.domain.model.Candidate;
import com.android.votechain.common.data.cloud.cloud.ApiClient;
import com.android.votechain.common.data.cloud.cloud.ClientConstants;
import java.util.List;
import rx.Observable;

/**
 * 16/06/2016.
 */
public class RestApiImpl extends ApiClient<CandidateApiService> implements RestApi {

  @Override protected Class<CandidateApiService> getApiService() {
    return CandidateApiService.class;
  }

  @Override protected String getBaseURL() {
    return ClientConstants.BASE_URL_CANDIDATES;
  }

  @Override public Observable<List<Candidate>> getCandidates() {
    return apiService.getCandidates();
  }

  @Override public Observable<Candidate> getCandidate(int idCandidate) {
    return apiService.getCandidate(idCandidate);
  }
}
