package com.kad.routermodule.provide

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class KadDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATA_BASE_NAME, null, VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_SQL)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    companion object {

        private val DATA_BASE_NAME = "kad_database"

        private val VERSION = 100

        private val CREATE_TABLE_SQL = "create table cart(_ID INTEGER PRIMARY KEY AUTOINCREMENT,quantity INTEGER,userId text,goods_Id text);"
    }
}
