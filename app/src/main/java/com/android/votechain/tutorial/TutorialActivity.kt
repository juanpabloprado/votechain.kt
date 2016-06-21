package com.android.votechain.tutorial

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.support.v4.view.ViewPager
import com.android.votechain.R
import com.android.votechain.common.view.BaseActivity
import com.android.votechain.common.view.getCompatColor
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

    val colorAnimator by lazy {
        ValueAnimator.ofObject(ArgbEvaluator(), getCompatColor(R.color.purple), getCompatColor(R.color.indigo), getCompatColor(R.color.teal), getCompatColor(R.color.orange))
    }

    override fun getLayout(): Int {
        return R.layout.activity_tutorial
    }

    override fun initView() {
        super.initView()
        pager
        colorAnimator.addUpdateListener { animator -> pager.setBackgroundColor(animator.getAnimatedValue() as Int) }
        colorAnimator.setDuration(((4 - 1) * 10000000000).toLong());
        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                colorAnimator.currentPlayTime = ((positionOffset + position)* 10000000000).toLong()
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageSelected(position: Int) {
            }
        })
    }
}
