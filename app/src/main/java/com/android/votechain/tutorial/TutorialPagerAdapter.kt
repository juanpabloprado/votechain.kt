package com.android.votechain.tutorial

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class TutorialPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    companion object {
        const val WELCOME: Int = 0
        const val CANDIDATE: Int = 1
        const val PROPOSAL: Int = 2
        const val VOTE: Int = 3
        const val PAGE_COUNT: Int = 4
    }

    override fun getCount(): Int {
        return PAGE_COUNT;
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            WELCOME -> WelcomeFragment()
            CANDIDATE -> CandidateFragment()
            PROPOSAL -> ProposalFragment()
            VOTE -> VoteFragment()
            else -> WelcomeFragment()
        }
    }
}
