package com.kad.routermodule.provide

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import android.text.TextUtils

class KadContentProvider : ContentProvider() {

    private var kadDatabaseHelper: KadDatabaseHelper? = null

    private var db: SQLiteDatabase? = null

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        var result = 0
        if (db != null) {
            db!!.beginTransaction()
            result = db!!.delete(uri.path, selection, selectionArgs)
            db!!.setTransactionSuccessful()
            db!!.endTransaction()
        }
        return result
    }

    override fun getType(uri: Uri): String? {
        when (matchUri.match(uri)) {
            1 ->

                return "vnd.android.cursor.dir/vnd." + uri.authority + "." + uri.path.replace("/","")
            2 ->

                return "vnd.android.cursor.item/vnd." + uri.authority + "." + uri.path.replace("/","")
        }
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        var rowId:Long=0
        if (db != null) {
            db!!.beginTransaction()
            rowId = db!!.insert(uri.path.replace("/",""), null, values)
            db!!.setTransactionSuccessful()
            db!!.endTransaction()
        }
        if(rowId>0){
           return ContentUris.withAppendedId(uri,rowId)
        }
        return null
    }

    override fun onCreate(): Boolean {
        kadDatabaseHelper = KadDatabaseHelper(context!!)
        db = kadDatabaseHelper!!.writableDatabase
        return true
    }

    override fun query(uri: Uri, projection: Array<String>?, selection: String?,
                       selectionArgs: Array<String>?, sortOrder: String?): Cursor? {
        var selection = selection
        var sortOrder = sortOrder
        when (matchUri.match(uri)) {
            1 -> if (TextUtils.isEmpty(sortOrder)) {
                sortOrder = " _ID ASC"
            }
            2 ->

                selection += " userId =" + uri.lastPathSegment
            else -> {
            }
        }

        return  db!!.query(uri.path.replace("/",""), projection, selection, selectionArgs, null, null, sortOrder)
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?,
                        selectionArgs: Array<String>?): Int {
        var result = 0
        if (db != null) {
            db!!.beginTransaction()
            result = db!!.update(uri.path, values, selection, selectionArgs)
            db!!.setTransactionSuccessful()
            db!!.endTransaction()
        }

        return result
    }

    companion object {

        private val matchUri = UriMatcher(UriMatcher.NO_MATCH)

        init {
            matchUri.addURI("com.kad.app.data", "cart", 1)//匹配所有数据
            matchUri.addURI("com.kad.app.data", "cart/#", 2)//根据id查询
        }
    }
}
