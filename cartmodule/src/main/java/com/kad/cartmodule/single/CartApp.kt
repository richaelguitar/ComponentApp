package com.kad.cartmodule.single

import com.kad.basemodule.ICoreApp

/**
 * 购物车app
 */
class CartApp :ICoreApp(){

    override fun initModule() {
        println("---initCartApp---")
    }

    override fun initConfig() {
        println("---initCartConfig---")
    }
}