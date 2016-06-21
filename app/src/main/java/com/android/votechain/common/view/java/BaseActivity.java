package com.android.votechain.common.view.java;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.android.votechain.R;

/**
 * 27/11/15.
 * <p/>
 * <p/>
 * <p>
 * BaseActivity contains some modifications to the native AppCompatActivity.
 * Mainly, it use ButterKnife for view binding and it automatically check if
 * toolbar exists.
 * </p>
 */
public abstract class BaseActivity extends AppCompatActivity {

  @Nullable @BindView(R.id.toolbar) Toolbar mToolbar;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayout());
    bindViews();
    setupToolbar();
    setupActionBar(getSupportActionBar());
    initView();
    initView(savedInstanceState);
  }

  /**
   * Use this method to initialize view components. This method is called after {@link
   * BaseActivity#bindViews()}
   */
  protected void initView() {
  }

  protected void initView(Bundle savedInstanceState) {
  }

  /**
   * Its common use a toolbar within activity, if it exists in the
   * layout this will be configured
   */
  protected void setupToolbar() {
    if (mToolbar != null) {
      setSupportActionBar(mToolbar);
    }
  }

  protected void setupActionBar(ActionBar actionBar) {

  }

  /**
   * Every object annotated with {@link BindView} its gonna injected trough butterknife
   */
  private void bindViews() {
    ButterKnife.bind(this);
  }

  @Nullable public Toolbar getToolbar() {
    return mToolbar;
  }

  /**
   * @return The layout that's gonna be the activity view.
   */
  protected abstract int getLayout();
}
