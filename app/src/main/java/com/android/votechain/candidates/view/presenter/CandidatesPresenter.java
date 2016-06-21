package com.android.votechain.candidates.view.presenter;

import android.widget.ImageView;
import com.android.votechain.candidates.data.repository.CandidatesRepository;
import com.android.votechain.candidates.data.repository.ServerCandidatesRespository;
import com.android.votechain.candidates.domain.model.Candidate;
import com.android.votechain.candidates.view.viewmvp.CandidatesView;
import com.android.votechain.common.view.java.Presenter;
import java.util.List;
import rx.Subscriber;

/**
 * 21/06/2016.
 */
public class CandidatesPresenter extends Presenter<CandidatesView> {

  private CandidatesRepository candidatesRepository;

  public CandidatesPresenter() {
    candidatesRepository = new ServerCandidatesRespository();
  }

  @Override public void initialize() {
    super.initialize();
    getView().hideMessageErrorConnection();
    getView().showLoadingCandidates();
    candidatesRepository.getCandidates(new CandidateSubscriber());
  }

  public void selectCandidate(Candidate candidate, ImageView imageView)
  {
    getView().showDetailCandidate(candidate.getCandidateId(),candidate.getName(),imageView);
  }



  @Override public void destroy() {

  }

  private class CandidateSubscriber extends Subscriber<List<Candidate>> {
    @Override public void onCompleted() {
      getView().hideLoadingCandidates();
    }

    @Override public void onError(Throwable e) {
      getView().hideLoadingCandidates();
      getView().showMessageErrorConnection();
    }

    @Override public void onNext(List<Candidate> candidates) {
      getView().showListCandidates(candidates);
    }
  }
}
