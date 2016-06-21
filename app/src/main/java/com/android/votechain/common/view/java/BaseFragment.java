package com.android.votechain.common.view.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 27/11/15.
 * <p>
 * * <p>
 * A fragment like an activity only will execute operations that affect the UI.
 * These operations are defined by a view model and are triggered by its presenter.
 * </p>
 */

public abstract class BaseFragment extends Fragment {

  private Unbinder mUnbinder;

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(getFragmentLayout(), container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    bindViews(view);
    setupActionBar(getSupportActionBar());
    initView(view, savedInstanceState);
  }

  protected void setupActionBar(ActionBar actionBar) {

  }

  /**
   * Use this method to initialize view components. This method is called after {@link
   * BaseActivity#bindViews()}
   */
  protected void initView(View view, Bundle savedInstanceState) {
  }

  protected void enableOptionsMenu() {
    setHasOptionsMenu(true);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbindViews();
  }

  /**
   * Replace all the annotated fields with ButterKnife annotations with the proper value
   */
  private void bindViews(View rootView) {
    mUnbinder = ButterKnife.bind(this, rootView);
  }

  private void unbindViews() {
    mUnbinder.unbind();
  }

  public void setResultAactivity(int resultCode, Intent data) {
    getActivity().setResult(resultCode, data);
  }

  public void finishActivity() {
    getActivity().finish();
  }

  public FragmentManager getActivitySupportFragmentManager() {
    return getActivity().getSupportFragmentManager();
  }

  public ActionBar getSupportActionBar() {
    return ((BaseActivity) getActivity()).getSupportActionBar();
  }

  public void addFragment(Fragment fragment) {
    ((BaseFragActivity) getActivity()).addFragment(fragment);
  }

  public void addFragment(Fragment fragment, @AnimRes int enter, @AnimRes int exit,
      @AnimRes int popEnter, @AnimRes int popExit) {
    ((BaseFragActivity) getActivity()).addFragment(fragment, enter, exit, popEnter, popExit);
  }

  public void replaceFragment(Fragment fragment) {
    ((BaseFragActivity) getActivity()).replaceFragment(fragment);
  }

  public void replaceFragment(Fragment fragment, @AnimRes int enter, @AnimRes int exit) {
    ((BaseFragActivity) getActivity()).replaceFragment(fragment, enter, exit);
  }

  public void popConcurrentFragment() {
    ((BaseFragActivity) getActivity()).popFragment();
  }

  @Nullable public Toolbar getToolbar() {
    return ((BaseActivity) getActivity()).getToolbar();
  }

  /**
   * Specify the layout of the fragment to be inflated in the {@link BaseFragment#onCreateView(LayoutInflater,
   * ViewGroup, Bundle)}
   */
  protected abstract int getFragmentLayout();
}
