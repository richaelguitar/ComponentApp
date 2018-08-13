package com.kad.usermodule.single

import com.kad.basemodule.ICoreApp

class UserApp : ICoreApp(){
    override fun initModule() {
        println("---initUserModule---")
    }

    override fun initConfig() {
        println("---initUserConfig---")
    }
}