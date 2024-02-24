package com.example.tap

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    var counter = 0
    var pref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pref = getSharedPreferences("TABLE", MODE_PRIVATE)

        var number: TextView = findViewById(R.id.Number)

        counter = pref?.getInt("counter", 0)!!
        number.text = counter.toString()
    }

    fun Tap(view: View) {
        var number: TextView = findViewById(R.id.Number)
        var backFone: ConstraintLayout = findViewById(R.id.back)
        counter++
        if (counter == 3000) {
            Toast.makeText(this, "Very Good!", Toast.LENGTH_SHORT).show()
        }
        if (counter == 10000) {
            Toast.makeText(this, "Very Very Good!", Toast.LENGTH_SHORT).show()
        }
        if (counter == 100000)
        {
            backFone.setBackgroundColor(Color.DKGRAY)
        }
        if (counter == 1000000)
        {
            backFone.setBackgroundColor(Color.CYAN)
        }
        number.text = counter.toString()
        saveData(counter)
    }

    fun saveData(res: Int)
    {
        val editor = pref?.edit()
        editor?.putInt("counter", res)
        editor?.apply()
    }

}