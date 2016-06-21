package com.android.votechain.candidates.data.net;

import com.android.votechain.candidates.domain.model.Candidate;
import com.android.votechain.common.data.cloud.cloud.ClientConstants;
import java.util.List;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 16/06/2016.
 */
public interface RestApi {

  Observable<List<Candidate>> getCandidates();

  Observable<Candidate> getCandidate(int idCandidate);
}
