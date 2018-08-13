package com.kad.goodsmodule

import android.text.TextUtils
import android.widget.Toast
import com.kad.basemodule.BaseActivity
import com.kad.routermodule.util.CoreServiceManager
import kotlinx.android.synthetic.main.goods_activity_main.*

class GoodsActivity : BaseActivity() {

    private var goodsId :String? = null

    override fun getLayoutId(): Int {
        return R.layout.goods_activity_main
    }

    override fun initView() {
        setTitle("商品详情")
        btn_plus.setOnClickListener {
            var count = edt_count.text.toString().toInt()
            count++
           if(count<=Int.MAX_VALUE){
               edt_count.setText(count.toString())
           }
        }

        btn_minus.setOnClickListener {
            var count = edt_count.text.toString().toInt()
            count--
           if(count>=1){
               edt_count.setText(count.toString())
           }
        }

        btn_add_cart.setOnClickListener {
            val isSuccess = CoreServiceManager.instance.iCartService.addCart(goodsId,edt_count.text.toString().toInt())
            if(isSuccess){
                Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show()
            }
        }

        btn_show_cart_count.setOnClickListener {
            val quantity:Int = CoreServiceManager.instance.iCartService.showCartCount()
            if(quantity>0){
                Toast.makeText(this,"购物车总数量为："+quantity,Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun initData() {

         goodsId = intent.getStringExtra("ids")

        if (TextUtils.isEmpty(goodsId)) {
            Toast.makeText(this, "商品编号：" +goodsId, Toast.LENGTH_SHORT).show()
        }
    }
}
