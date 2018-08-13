package com.kad.goodsmodule.single

import com.kad.basemodule.ICoreApp

class GoodsApp : ICoreApp(){

    override fun initModule() {
        println("-----initGoodsModule------")
    }

    override fun initConfig() {
        println("-----initGoodsConfig------")
    }
}