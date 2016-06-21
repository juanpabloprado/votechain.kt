package com.android.votechain.common.view;

import android.support.v4.app.Fragment;

/**
 * 27/11/15.
 * <p>
 * * <p>
 * A fragment like an activity only will execute operations that affect the UI.
 * These operations are defined by a view model and are triggered by its presenter.
 * </p>
 */

public abstract class BaseFragment extends Fragment {

  //@Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
  //    Bundle savedInstanceState) {
  //  return inflater.inflate(getFragmentLayout(), container, false);
  //}
  //
  //@Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
  //  super.onViewCreated(view, savedInstanceState);
  //  setupActionBar(getSupportActionBar());
  //}
  //
  //protected void setupActionBar(ActionBar actionBar) {
  //
  //}
  //
  //protected void enableOptionsMenu() {
  //  setHasOptionsMenu(true);
  //}
  ///**
  // * Replace all the annotated fields with ButterKnife annotations with the proper value
  // */
  //
  //public void setResultAactivity(int resultCode, Intent data) {
  //  getActivity().setResult(resultCode, data);
  //}
  //
  //public void finishActivity() {
  //  getActivity().finish();
  //}
  //
  //public FragmentManager getActivitySupportFragmentManager() {
  //  return getActivity().getSupportFragmentManager();
  //}
  //
  //public ActionBar getSupportActionBar() {
  //  return ((BaseActivity) getActivity()).getSupportActionBar();
  //}
  //
  //public void addFragment(Fragment fragment) {
  //  ((BaseFragActivity) getActivity()).addFragment(fragment);
  //}
  //
  //public void addFragment(Fragment fragment, @AnimRes int enter, @AnimRes int exit,
  //    @AnimRes int popEnter, @AnimRes int popExit) {
  //  ((BaseFragActivity) getActivity()).addFragment(fragment, enter, exit, popEnter, popExit);
  //}
  //
  //public void replaceFragment(Fragment fragment) {
  //  ((BaseFragActivity) getActivity()).replaceFragment(fragment);
  //}
  //
  //public void replaceFragment(Fragment fragment, @AnimRes int enter, @AnimRes int exit) {
  //  ((BaseFragActivity) getActivity()).replaceFragment(fragment, enter, exit);
  //}
  //
  //public void popConcurrentFragment() {
  //  ((BaseFragActivity) getActivity()).popFragment();
  //}
  //
  //@Nullable public Toolbar getToolbar() {
  //  return ((BaseActivity) getActivity()).getToolbar();
  //}
  //
  ///**
  // * Specify the layout of the fragment to be inflated in the {@link BaseFragment#onCreateView(LayoutInflater,
  // * ViewGroup, Bundle)}
  // */
  //protected abstract int getFragmentLayout();
}

