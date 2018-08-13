package com.kad.routermodule.util

import android.content.Context

import com.kad.routermodule.service.ICartService
import com.kad.routermodule.service.IGoodsService
import com.kad.routermodule.service.IMainService
import com.kad.routermodule.service.IUserService

import java.lang.ref.WeakReference

class CoreServiceManager private constructor(context: Context) {

    private val contextWeakReference: WeakReference<Context>

    private val mainService:IMainService?
    private val cartService:ICartService?
    private val goodsService:IGoodsService?
    private val userService:IUserService?


    val iMainService: IMainService
        get() {
            mainService!!.init(contextWeakReference.get()!!)
            return mainService
        }

    val iCartService: ICartService
        get() {

            cartService!!.init(contextWeakReference.get()!!)
            return cartService
        }


    val iGoodsService: IGoodsService
        get() {
            goodsService!!.init(contextWeakReference.get()!!)
            return goodsService
        }


    val iUserService: IUserService
        get() {
            userService!!.init(contextWeakReference.get()!!)
            return userService
        }

    init {
        this.contextWeakReference = WeakReference(context)
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
