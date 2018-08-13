package com.kad.usermodule.service

import android.content.Context
import android.content.Intent
import com.kad.routermodule.service.IUserService
import com.kad.usermodule.LoginActivity

class UserServiceImpl : IUserService{

    var mContext:Context? = null

    override fun isLogin(): Boolean {
        return true
    }

    override fun login() {
        mContext!!.startActivity(Intent(mContext,LoginActivity::class.java))
    }

    override fun init(context: Context) {
        mContext = context
    }

    override fun showList() {

    }

    override fun showDetail(id: String) {

    }
}