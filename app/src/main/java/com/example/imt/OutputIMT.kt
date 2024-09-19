package com.example.imt

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OutputIMT : AppCompatActivity() {

    private lateinit var first:TextView
    private lateinit var second:TextView
    private lateinit var thrid:TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_output_imt)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        second = findViewById(R.id.second)
        thrid = findViewById(R.id.thrid)

        val height = intent.getStringExtra("height")!!.toDouble()/100
        val weight = intent.getStringExtra("weight")!!.toDouble()
        //Toast.makeText(this,"height = $height\nweight = $weight", Toast.LENGTH_SHORT).show()
        val imt = weight/(height*height)
        second.text = imt.toString()
        if (imt < 16){
            thrid.setText(R.string.itm0)
        } else if (imt < 18.5){
            thrid.setText(R.string.itm1)
        } else if (imt < 25){
            thrid.setText(R.string.itm2)
        }else if (imt < 30){
            thrid.setText(R.string.itm3)
        }else if (imt < 35){
            thrid.setText(R.string.itm4)
        }else if (imt < 40){
            thrid.setText(R.string.itm5)
        }else{
            thrid.setText(R.string.itm6)
        }
    }

    fun onClickBTN(view: View) {
        finish()
    }

}