package com.kad.goodsmodule.service

import android.content.Context
import android.content.Intent
import android.os.Build
import com.kad.goodsmodule.GoodsActivity
import com.kad.routermodule.service.IGoodsService

class GoodsServiceImpl:IGoodsService{

    var mContext:Context? = null

    override fun init(context: Context) {
        mContext = context
    }

    override fun showList() {

    }

    override fun showDetail(id: String) {
         val intent =   Intent(mContext,GoodsActivity::class.java)
        intent.putExtra("ids",id)
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N){
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        mContext!!.startActivity(intent)
    }
}