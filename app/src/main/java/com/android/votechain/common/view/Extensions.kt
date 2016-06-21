package com.android.votechain.common.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide


fun ViewGroup.inflate(layoutResId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutResId, this, attachToRoot)
}

fun Activity.getCompatColor(colorRes: Int): Int {
    return ContextCompat.getColor(this, colorRes)
}

fun Fragment.startActivity(c: Class<*>) {
    val intent: Intent = Intent(context, c)
    startActivity(intent)
}

fun AppCompatActivity.startActivity(c: Class<*>) {
    val intent: Intent = Intent(baseContext, c)
    startActivity(intent)
}

fun ImageView.loadURL(url: String?) {
    Glide
            .with(context)
            .load(url)
            .fitCenter()
            .into(this)
}