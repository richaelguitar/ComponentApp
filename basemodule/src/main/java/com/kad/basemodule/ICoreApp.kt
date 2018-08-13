package com.kad.basemodule

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex


abstract class ICoreApp: Application(){

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        initConfig()
        initModule()
    }


    abstract fun initModule()

    abstract fun initConfig()
}