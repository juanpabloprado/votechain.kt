package com.android.votechain.candidates.view.viewmvp;

import com.android.votechain.common.view.java.Presenter;

/**
 * 21/06/2016.
 */
public interface CandidatesView extends Presenter.View {



  void showLoadingCandidates();

  void hideLoadingCandidates();

  void showMessageErrorConnection();

  void hideMessageErrorConnection();
}
