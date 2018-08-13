package com.kad.routermodule.util

import android.content.Context

import com.kad.routermodule.service.ICartService
import com.kad.routermodule.service.IGoodsService
import com.kad.routermodule.service.IMainService
import com.kad.routermodule.service.IUserService



class CoreServiceManager private constructor(context: Context) {

    //由于content是在Application中的onCreate里初始化，所以不担心内存泄漏的问题
    private var context: Context? = null

    private val mainService:IMainService?
    private val cartService:ICartService?
    private val goodsService:IGoodsService?
    private val userService:IUserService?


    val iMainService: IMainService
        get() {
            mainService!!.init(context!!)
            return mainService
        }

    val iCartService: ICartService
        get() {

            cartService!!.init(context!!)
            return cartService
        }


    val iGoodsService: IGoodsService
        get() {
            goodsService!!.init(context!!)
            return goodsService
        }


    val iUserService: IUserService
        get() {
            userService!!.init(context!!)
            return userService
        }

    init {
        this.context = context
        this.mainService  = ReflectUtils.getICoreService(ServicePath.MAIN_PATH.toString()) as IMainService?
        this.cartService = ReflectUtils.getICoreService(ServicePath.CART_PATH.toString()) as ICartService?
        this.goodsService = ReflectUtils.getICoreService(ServicePath.GOODS_PATH.toString()) as IGoodsService?
        this.userService = ReflectUtils.getICoreService(ServicePath.USER_PATH.toString()) as IUserService?
    }

    companion object {

        private var coreServiceManager: CoreServiceManager? = null

        fun instance(context: Context) {
            if (coreServiceManager == null) {
                synchronized(CoreServiceManager::class.java) {
                    if (coreServiceManager == null) {
                        coreServiceManager = CoreServiceManager(context)
                    }
                }
            }
        }

        val instance: CoreServiceManager
            get() {
                try {
                    if (coreServiceManager == null) {
                        throw NullPointerException("必须先调用instance方法进行初始化")
                    }
                }catch (ex:Exception){
                    ex.printStackTrace()
                }
                return coreServiceManager!!
            }
    }


}
