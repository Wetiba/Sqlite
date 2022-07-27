package com.example.sqlitedb2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        printName.setOnClickListener {
            val db=DBHelper(this,null)
            val name=entername.text.toString()
            val age=enteragw.text.toString()

            db.addName(name,age)
            Toast.makeText(this,name+"added to db",Toast.LENGTH_LONG).show()
            entername.text.clear()
            enteragw.text.clear()

        }
    }
}