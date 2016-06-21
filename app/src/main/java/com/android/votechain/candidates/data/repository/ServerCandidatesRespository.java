package com.android.votechain.candidates.data.repository;

import com.android.votechain.candidates.data.net.RestApi;
import com.android.votechain.candidates.data.net.RestApiImpl;
import com.android.votechain.candidates.domain.model.Candidate;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 21/06/2016.
 */
public class ServerCandidatesRespository implements CandidatesRepository {

  private final RestApi restApi;

  public ServerCandidatesRespository() {
    restApi = new RestApiImpl();
  }

  @Override public void getCandidates(Subscriber<List<Candidate>> UseCaseSubscriber) {
    restApi.getCandidates().subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(UseCaseSubscriber);
  }

  @Override
  public void getCandidate(int idCandidate,Subscriber<Candidate> UseCaseSubscriber) {
     restApi.getCandidate(idCandidate).subscribeOn(Schedulers.newThread())
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe(UseCaseSubscriber);
  }
}
