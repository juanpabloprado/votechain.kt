package com.android.votechain.common.view

import android.app.Activity
import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


fun ViewGroup.inflate(layoutResId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutResId, this, attachToRoot)
}

fun Activity.getCompatColor(colorRes:Int): Int{
    return ContextCompat.getColor(this, colorRes)
}
