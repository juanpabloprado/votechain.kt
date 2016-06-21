package com.android.votechain.tutorial

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.annotation.TargetApi
import android.os.Build
import android.support.v4.view.ViewPager
import android.view.WindowManager
import com.android.votechain.R
import com.android.votechain.candidates.view.activity.CandidatesActivity
import com.android.votechain.common.view.BaseActivity
import com.android.votechain.common.view.getCompatColor
import com.android.votechain.common.view.startActivity
import kotlinx.android.synthetic.main.activity_tutorial.*
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
        val animator: ValueAnimator = ValueAnimator.ofObject(ArgbEvaluator(), getCompatColor(R.color.purple), getCompatColor(R.color.indigo), getCompatColor(R.color.teal), getCompatColor(R.color.orange))
        animator.addUpdateListener { animator -> pager.setBackgroundColor(animator.getAnimatedValue() as Int) }
        animator.duration = ((4 - 1) * 10000000000).toLong();
        animator
    }

    override fun getLayout(): Int {
        return R.layout.activity_tutorial
    }

    override fun initView() {
        super.initView()
        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                colorAnimator.currentPlayTime = ((positionOffset + position) * 10000000000).toLong()
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageSelected(position: Int) {
            }
        })

        if (Build.VERSION.SDK_INT >= 19)
            setStatusBarTranslucent(true)

        buttonVote.setOnClickListener { startActivity(CandidatesActivity::class.java) }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    fun setStatusBarTranslucent(makeTranslucent: Boolean) {
        if (makeTranslucent) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
}
