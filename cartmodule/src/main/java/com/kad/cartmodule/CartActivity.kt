package com.kad.cartmodule


import com.kad.basemodule.BaseActivity

class CartActivity : BaseActivity() {

    override fun initView() {
        println("---initCartView---")
    }

    override fun initData() {
        setTitle("购物车")
        println("---initCartData---")
    }

    override fun getLayoutId(): Int {
        return R.layout.cart_activity_main
    }
}
