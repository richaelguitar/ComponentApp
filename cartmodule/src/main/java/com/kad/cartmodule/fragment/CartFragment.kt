package com.kad.cartmodule.fragment


import android.view.View
import android.widget.Button
import android.widget.Toast
import com.kad.basemodule.BaseLazyLoadFragment
import com.kad.cartmodule.R
import com.kad.routermodule.util.CoreServiceManager


class CartFragment : BaseLazyLoadFragment(){

    override fun getLayoutId(): Int {
        return R.layout.cart_fragment_layout
    }

    override fun initView(view: View) {
        val goDetail = view.findViewById<Button>(R.id.btn_go_goods_detail)
        goDetail!!.setOnClickListener{
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