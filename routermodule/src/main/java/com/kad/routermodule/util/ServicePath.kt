package com.kad.routermodule.util

/**
 * 各个模块实现类配置
 */
enum class ServicePath{

    MAIN_PATH{
        override fun toString(): String {
            return "com.kad.mainmodule.service.MainServiceImpl"
        }
    },
    CART_PATH{
        override fun toString(): String {
            return "com.kad.cartmodule.service.CartServiceImpl"
        }
    },
    GOODS_PATH{
        override fun toString(): String {
            return "com.kad.goodsmodule.service.GoodsServiceImpl"
        }
    },
    USER_PATH{
        override fun toString(): String {
            return "com.kad.usermodule.service.UserServiceImpl"
        }
    }
}