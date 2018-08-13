package com.kad.mainmodule.single

import com.kad.basemodule.ICoreApp

class MainSingleApp :ICoreApp(){

    override fun initModule() {
        println("---initMainModule---")
    }

    override fun initConfig() {
        println("---initMainConfig---")
    }
}