package com.kad.mainmodule

import com.kad.basemodule.ICoreApp
import com.kad.routermodule.util.CoreServiceManager

class MainApp :ICoreApp(){
    override fun initModule() {
        println("---initMainModule---")
        CoreServiceManager.instance(this)
    }

    override fun initConfig() {
        println("---initMainConfig---")
    }
}