package com.android.votechain.tutorial

import android.support.v4.view.ViewPager
import com.android.votechain.R
import com.android.votechain.common.view.BaseActivity
import me.relex.circleindicator.CircleIndicator

class TutorialActivity : BaseActivity() {

    val pager by lazy {
        val viewpager: ViewPager = findViewById(R.id.viewPager) as ViewPager
        viewpager.adapter = adapter
        indicator.setViewPager(viewpager)
        viewpager
    }

    val adapter by lazy {
        val pagerAdapter: TutorialPagerAdapter = TutorialPagerAdapter(supportFragmentManager)
        pagerAdapter
    }

    val indicator by lazy {
        val circles: CircleIndicator = findViewById(R.id.pagerIndicator) as CircleIndicator
        circles
    }

    override fun getLayout(): Int {
        return R.layout.activity_tutorial
    }

    override fun initView() {
        super.initView()
        pager
    }
}
