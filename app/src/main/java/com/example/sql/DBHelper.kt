//package com.example.sql
//
//import android.content.ContentValues
//import android.content.Context
//import android.database.Cursor
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//
//class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?): SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
//    companion object{
//         const val DATABASE_NAME = "TestDataBase"
//         const val DATABASE_VERSION = 1
//         const val TABLE_NAME = "details"
//         const val ID_COL = "id"
//        const val NAME_COL = "names"
//         const val AGE_COL = "age"
//    }
//
//
//    override fun onCreate(db: SQLiteDatabase){
//        val query = ("CREATE TABLE $TABLE_NAME ($ID_COL INTEGER PRIMARY KEY, $NAME_COL TEXT,$AGE_COL TEXT)")
//        db.execSQL(query)
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int){
//        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
//    }
//
//    fun addName(name: String, age: String){
//        val values = ContentValues()
//        values.put(NAME_COL, name)
//        values.put(AGE_COL, age)
//
//        val db = this.writableDatabase
//        db.insert(TABLE_NAME, null, values)
//        db.close()
//    }
//
//    fun getName(): Cursor? {
//        val db = this.readableDatabase
//        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
//    }
//
//    fun deleteDb(){
//        val db = this.writableDatabase
//        db.execSQL("DELETE FROM $TABLE_NAME")
//    }
//
//}

package com.example.sql

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?): SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION){
    companion object{
        val DATABASE_NAME = "database"
        val DATABASE_VERSION = 1
        val TABLE_NAME = "test"
        val ID_COL = "id"
        val NAME_COL = "name"
        val AGE_COL = "age"
    }

    override fun onCreate(db: SQLiteDatabase){
        val query = "CREATE TABLE $TABLE_NAME ($ID_COL INTEGER PRIMARY KEY, $NAME_COL TEXT, $AGE_COL TEXT)"
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int){
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
    }

    fun addItems(id: String, name: String, age: String){
        val values = ContentValues()
        values.put(ID_COL, id)
        values.put(NAME_COL, name)
        values.put(AGE_COL, age)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getItems(): Cursor?{
        val db = this.writableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

    fun deleteItems(){
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_NAME")
    }

}