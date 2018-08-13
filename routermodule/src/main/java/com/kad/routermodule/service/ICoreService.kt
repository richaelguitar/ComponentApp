package com.kad.routermodule.service

import android.content.Context

interface ICoreService{

    fun init(context:Context)

    fun showList()

    fun showDetail(id:String)
}