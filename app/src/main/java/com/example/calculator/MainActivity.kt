package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnSelectedEvent (view:View) {
        if (isClear){
            etShowData.setText("")
        }
        isClear = false
        val btnSelect = view as Button
        var btnClickValue = etShowData.text.toString()

        when (btnSelect.id) {
            btn0.id -> btnClickValue += "0"
            btn1.id -> btnClickValue += "1"
            btn2.id -> btnClickValue += "2"
            btn3.id -> btnClickValue += "3"
            btn4.id -> btnClickValue += "4"
            btn5.id -> btnClickValue += "5"
            btn6.id -> btnClickValue += "6"
            btn7.id -> btnClickValue += "7"
            btn8.id -> btnClickValue += "8"
            btn9.id -> btnClickValue += "9"
            btnDot.id -> btnClickValue += "."
            btnPlusMinus.id -> btnClickValue = "-" + btnClickValue
        }
        etShowData.setText(btnClickValue)
    }

    private var op = "/"
    private var oldNumber = ""
    private var isClear = true
    fun btnOperationEvent (view:View){
        val btnSelect = view as Button
        when (btnSelect.id){
            btnDivide.id -> {
                op = "/"
            }
            btnMulti.id -> {
                op = "*"
            }
            btnSub.id -> {
                op = "-"
            }
            btnAdd.id ->{
                op = "+"
            }
        }
        oldNumber = etShowData.text.toString()
        isClear = true
    }

    fun btnEqualEvent (view:View){
        val newNumber = etShowData.text.toString()
        var finalNumber:Double? = null

        when (op){
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        etShowData.setText(finalNumber.toString())
        isClear = true
    }
}
