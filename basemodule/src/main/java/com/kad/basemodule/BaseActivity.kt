package com.kad.basemodule

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView

/**
 * Activity公共基类
 */
  abstract class BaseActivity : AppCompatActivity() {


    private var titleTextView: TextView? = null

    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.abc_slide_in_bottom,R.anim.abc_slide_out_bottom)
        setContentView(getLayoutId())
        initToolbar()
        initView()
        initData()
    }

    abstract fun getLayoutId():Int

    abstract fun initView()

    abstract fun initData()

    private fun initToolbar() {

        titleTextView = findViewById(R.id.tv_title)

        toolbar = findViewById(R.id.toolbar)

        if (toolbar != null) {
            if (toolbar!!.visibility == View.GONE) {
                toolbar!!.visibility = View.VISIBLE
            }
            toolbar!!.setNavigationIcon(R.mipmap.arrow_back)
            toolbar!!.setNavigationOnClickListener { finish() }
        }
    }

    fun setTitle(title: String) {
        if (titleTextView != null) {
            if (titleTextView!!.visibility == View.GONE) {
                titleTextView!!.visibility = View.VISIBLE
            }
            titleTextView!!.text = title
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.abc_slide_in_bottom,R.anim.abc_slide_out_bottom)
    }

}
