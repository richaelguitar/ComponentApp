package com.kad.cartmodule.fragment


import android.view.View
import android.widget.Toast
import com.kad.basemodule.BaseLazyLoadFragment
import com.kad.cartmodule.R
import com.kad.routermodule.util.CoreServiceManager
import kotlinx.android.synthetic.main.cart_fragment_layout.*


class CartFragment : BaseLazyLoadFragment(){

    override fun getLayoutId(): Int {
        return R.layout.cart_fragment_layout
    }

    override fun initView(view: View) {

        btn_go_goods_detail!!.setOnClickListener{
            CoreServiceManager.instance.iGoodsService.showDetail("123456")
        }
    }

    override fun initData() {
        val count:Int = CoreServiceManager.instance.iCartService.showCartCount()
        Toast.makeText(activity,"购物车商品数量="+count,Toast.LENGTH_SHORT).show()
    }

    override fun getPageArguments() {

    }
}