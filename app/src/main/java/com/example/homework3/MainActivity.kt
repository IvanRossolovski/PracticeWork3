package com.example.homework3

import android.widget.Button
import android.widget.TextView
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.SimpleAdapter.ViewBinder
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework3.db.MyDbManager
class MainActivity : AppCompatActivity() {

    val myDbManager = MyDbManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onClickSave(view: View) {
        var tvTest:TextView = findViewById(R.id.tvTest)
        var edTitle:TextView = findViewById(R.id.edTitle)
        var edContent:TextView = findViewById(R.id.edContent)
        myDbManager.openDb()
        myDbManager.insertToDb(edTitle.text.toString(), edContent.text.toString())
        tvTest.text = ""
        val datalist = myDbManager.readDbData()
        for(item in datalist){
            tvTest.append(item)
            tvTest.append("\n")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}