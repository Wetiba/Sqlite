package com.example.sqlitedb2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addName.setOnClickListener {
            val db=DBHelper(this,null)
            val name=entername.text.toString()
            val age=enteragw.text.toString()

            db.addName(name,age)
            Toast.makeText(this,name+"added to db",Toast.LENGTH_LONG).show()
            entername.text.clear()
            enteragw.text.clear()

        }
        printName.setOnClickListener {
            val db=DBHelper(this,null)

            val cursor=db.getName()
            cursor!!.moveToFirst()
            Name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COL))+ "\n")
            Age.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL))+ "\n")
            while (cursor.moveToNext()){
                Name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COL))+ "\n")
                Age.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL))+ "\n")

            }
            cursor.close()

        }
    }
}