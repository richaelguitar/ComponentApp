package com.kad.cartmodule.service

import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Build
import com.kad.cartmodule.CartActivity
import com.kad.routermodule.service.ICartService

class CartServiceImpl:ICartService{

    var mContext:Context? = null
    var uri: Uri ?= null

    init {
        this.uri = Uri.parse("content://com.kad.app.data/cart")
    }

    override fun addCart(goodsId: String?,quantity:Int): Boolean {

        val values = ContentValues()
        values!!.put("goods_id",goodsId)
        values!!.put("quantity",quantity)

        val uri:Uri = mContext!!.contentResolver.insert(uri,values)
        if(uri!!.lastPathSegment.toInt()>0){
            return true
        }
        return false
}

    override fun init(context: Context) {
        mContext = context
    }


    override fun showList() {

    }

    override fun showDetail(id: String) {

    }

    override fun goCart() {
        val intent = Intent(mContext,CartActivity::class.java)
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N){
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        mContext!!.startActivity(intent)
    }

    override fun showCartCount(): Int {
        var count = 0
        val cursor:Cursor = mContext!!.contentResolver!!.query(uri, arrayOf("quantity"),null,null,null)
        if(cursor.count>0){
            while (cursor.moveToNext()){
                count+= cursor.getString(cursor.getColumnIndex("quantity")).toInt()
            }
        }
        cursor.close()
        return count
    }
}