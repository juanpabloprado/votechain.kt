package com.android.votechain.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.votechain.R
import com.android.votechain.common.view.BaseFragment
import com.android.votechain.common.view.inflate


class WelcomeFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_welcome, false)
    }
}