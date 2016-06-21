package com.android.votechain.candidates.view.viewmvp;

import com.android.votechain.candidates.domain.model.Candidate;
import com.android.votechain.common.view.java.Presenter;
import java.util.List;

/**
 * 21/06/2016.
 */
public interface CandidatesView extends Presenter.View {

  void showLoadingCandidates();

  void hideLoadingCandidates();

  void showMessageErrorConnection();

  void hideMessageErrorConnection();

  void showListCandidates(List<Candidate> candidates);
}
