package com.kad.mainmodule.single

import com.kad.basemodule.BaseActivity
import com.kad.mainmodule.R

class MainSingleActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main_single
    }

    override fun initView() {
        println("----initMainSingleView----")
    }

    override fun initData() {
        println("----initMainSingleData----")
    }
}
