package com.example.sql

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var id: Int = 0

//        val addName = findViewById<Button>(R.id.addName)
//        val printName = findViewById<Button>(R.id.printName)
//        val deleteName = findViewById<Button>(R.id.Delete)
//        val entername = findViewById<EditText>(R.id.enter_name)
//        val enterage = findViewById<EditText>(R.id.enter_age)
//        val outname = findViewById<TextView>(R.id.name)
//        val outage = findViewById<TextView>(R.id.age)
//        addName.setOnClickListener {
//            val db = DBHelper(this, null)
//            val name = entername.text.toString()
//            val age = enterage.text.toString()
//            db.addName(name, age)
//            Toast.makeText(this, "$name is added to database", Toast.LENGTH_LONG).show()
//            enterage.text.clear()
//            entername.text.clear()
//        }
//        printName.setOnClickListener {
//            val db = DBHelper(this, null)
//            val cursor = db.getName()
//            cursor!!.moveToFirst()
//            val nameIndex: Int = cursor.getColumnIndex(DBHelper.NAME_COL)
//            val ageIndex: Int = cursor.getColumnIndex(DBHelper.AGE_COL)
//            outname.append(cursor.getString(nameIndex) + "\n")
//            outage.append(cursor.getString(ageIndex) + "\n")
//            while(cursor.moveToNext()){
//                outname.append(cursor.getString(nameIndex) + "\n")
//                outage.append(cursor.getString(ageIndex) + "\n")
//            }
//            cursor.close()
//        }

        val addName: EditText = findViewById(R.id.enter_name)
        val addAge: EditText = findViewById(R.id.enter_age)
        val btn_add: Button = findViewById(R.id.addName)
        val btn_get: Button = findViewById(R.id.printName)
        val btn_del: Button = findViewById(R.id.Delete)
        val out_name: TextView = findViewById(R.id.name)
        val out_age: TextView = findViewById(R.id.age)

        btn_add.setOnClickListener {
            val db = DBHelper(this, null)
            val name: String = addName.text.toString()
            val age: String = addAge.text.toString()
            db.addItems((++id).toString(), name, age)
            Toast.makeText(this, "$name is added", Toast.LENGTH_LONG).show()
            addAge.text.clear()
            addName.text.clear()
        }

        btn_get.setOnClickListener {
            val db = DBHelper(this, null)
            val cursor = db.getItems()
            cursor!!.moveToFirst()
            val nameIndex: Int = cursor.getColumnIndex(DBHelper.NAME_COL)
            val ageIndex: Int = cursor.getColumnIndex(DBHelper.AGE_COL)
            out_name.append(cursor.getString(nameIndex) + "\n")
            out_age.append(cursor.getString(ageIndex) + "\n")
            while (cursor.moveToNext()){
                out_name.append(cursor.getString(nameIndex) + "\n")
                out_age.append(cursor.getString(ageIndex) + "\n")
            }
            cursor.close()
        }

        btn_del.setOnClickListener {
            val db = DBHelper(this, null)
            db.deleteItems()

            out_name.text = ""
            out_age.text = ""
        }


    }
}