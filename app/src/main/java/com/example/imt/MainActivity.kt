package com.example.imt

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var weightET: EditText
    private lateinit var heightET: EditText
    private lateinit var button:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbar = findViewById(R.id.toolbar_menu)
        weightET = findViewById(R.id.weightET)
        heightET = findViewById(R.id.heightET)
        button = findViewById(R.id.button)

        setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.exit ->{
                finish()
            }
        }
        return true
    }
    fun onClickBTN(view: View) {
        if (!checked()){
            val intent = Intent(this, OutputIMT::class.java)
            intent.putExtra("weight", weightET.text.toString())
            intent.putExtra("height", heightET.text.toString())
            setResult(RESULT_OK, intent)
            startActivity(intent)
        }
    }
    private fun checked(): Boolean {
        if (weightET.text.isEmpty()) {
            weightET.setHintTextColor(ContextCompat.getColor(this, R.color.red))
            weightET.hint = "Поле не может быть пустым"
        }
        if (heightET.text.isEmpty()) {
            heightET.setHintTextColor(ContextCompat.getColor(this, R.color.red))
            heightET.hint = "Поле не может быть пустым"
        }
        if (weightET.text.isEmpty() || heightET.text.isEmpty()) {
            return true
        }
        return false
    }
    private fun default(){
        weightET.text.clear()
        weightET.setHintTextColor(ContextCompat.getColor(this, R.color.gray))
        weightET.hint = getText(R.string.youWeight)

        heightET.text.clear()
        heightET.setHintTextColor(ContextCompat.getColor(this, R.color.gray))
        heightET.hint = getText(R.string.youHeight)
    }
}