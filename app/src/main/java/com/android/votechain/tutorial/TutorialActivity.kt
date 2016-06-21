package com.android.votechain.tutorial

import android.support.v4.view.ViewPager
import com.android.votechain.R
import com.android.votechain.common.view.BaseActivity

class TutorialActivity : BaseActivity() {

    val viewPager by lazy {
        val viewpager: ViewPager = findViewById(R.id.viewPager) as ViewPager
        val adapter: TutorialPagerAdapter = TutorialPagerAdapter(supportFragmentManager)
        viewpager.adapter = adapter
        viewpager
    }

    override fun getLayout(): Int {
        return R.layout.activity_tutorial
    }

    override fun initView() {
        super.initView()
        viewPager
    }
}
