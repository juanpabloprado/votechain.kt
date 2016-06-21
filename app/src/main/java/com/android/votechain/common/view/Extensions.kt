package com.android.votechain.common.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 21/06/2016.
 */
fun ViewGroup.inflate(layoutId : Int, attachToRoot: Boolean = false): View {
  return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot);
}