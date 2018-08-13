package com.kad.basemodule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Fragment实现懒加载
 * 适合在一次性加载多个fragment里使用
 * 比如：viewPager里面
 */
abstract class BaseLazyLoadFragment :BaseFragment(){

    //是否可见
    var isVisibles = false

    //标志位，view已经初始化完成
    var isPrepared =false

    //是否是第一次加载
    var isFirstLoad = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        isFirstLoad = true
        isPrepared = true
        return inflater.inflate(getLayoutId(),container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if(userVisibleHint){
            isVisibles = true
            lazyLoad()
        }else{
            isVisibles = false
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if(!hidden){
            isVisibles = true
            lazyLoad()
        }else{
            isVisibles = false
        }
    }

    fun lazyLoad(){
        if(!isFirstLoad||!isPrepared||!isVisibles){
            return
        }
        isFirstLoad = false
        initData()
    }
}