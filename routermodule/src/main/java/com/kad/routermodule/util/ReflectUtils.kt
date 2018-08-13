package com.kad.routermodule.util

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.kad.routermodule.service.ICoreService


object ReflectUtils {

    fun getFragment(className: String): Fragment?{
        val fragment: Fragment
        try {
            fragment = Class.forName(className).newInstance() as Fragment
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }

        return fragment
    }

    fun startActivityWithName(context: Context, className: String) {
        var clazz: Class<*>? = null
        try {
            clazz = Class.forName(className).newInstance() as Class<*>
            startActivity(context, clazz)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    private fun startActivity(context: Context, clazz: Class<*>?) {

        context.startActivity(Intent(context, clazz))
    }

    fun getICoreService(className: String): ICoreService?{
        val service: ICoreService?

        try {
            service = Class.forName(className).newInstance() as ICoreService
        }catch (ex:Exception){
            ex.printStackTrace()
            return null
        }

        return service
    }
}
