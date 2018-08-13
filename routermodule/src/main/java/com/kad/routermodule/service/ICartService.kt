package com.kad.routermodule.service

interface ICartService : ICoreService{
    /*
      to do custom yourself methods
     */

    fun addCart(goodsId:String?,quantity:Int):Boolean

    fun goCart()

    fun showCartCount():Int



}