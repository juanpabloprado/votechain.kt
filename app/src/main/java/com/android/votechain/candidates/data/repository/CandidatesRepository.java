package com.android.votechain.candidates.data.repository;

import com.android.votechain.candidates.domain.model.Candidate;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

/**
 * 21/06/2016.
 */
public interface CandidatesRepository {

  void getCandidates(Subscriber<List<Candidate>> UseCaseSubscriber);
  void  getCandidate(int idCandidate,Subscriber<Candidate> UseCaseSubscriber);

}
