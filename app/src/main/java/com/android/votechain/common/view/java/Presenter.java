package com.android.votechain.common.view.java;

import android.content.Context;

/**
 * 12/04/16.
 */
public abstract class Presenter<T extends Presenter.View> {

  private T view;

  public T getView() {
    return view;
  }

  public void setView(T view) {
    this.view = view;
  }

  public void initialize() {

  }

  public abstract void destroy();



  public interface View {
    Context getContext();


  }

}
