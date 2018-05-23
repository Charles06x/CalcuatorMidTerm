package com.example.hp.calcuator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var b: Int = 1
        var numero1: String = ""
        var num1: Int = 0
        var numero2: String = ""
        var num2: Int = 0
        var operation: String = ""
        var op: String = ""

        uno.setOnClickListener {
            if (b == 1) {
                numero1 = numero1 + "1"
            } else {
                numero2 = numero2 + "1"
            }
        }
        dos.setOnClickListener {
            if (b == 1) {
                numero1 = numero1 + "2"
            } else {
                numero2 = numero2 + "2"
            }
        }
        tres.setOnClickListener {
            if (b == 1) {
                numero1 = numero1 + "3"
            } else {
                numero2 = numero2 + "3"
            }
        }
        cuatro.setOnClickListener {
            if (b == 1) {
                numero1 = numero1 + "4"
            } else {
                numero2 = numero2 + "4"
            }
        }
        cinco.setOnClickListener {
            if (b == 1) {
                numero1 = numero1 + "5"
            } else {
                numero2 = numero2 + "6"
            }
        }
        seis.setOnClickListener {
            if (b == 1) {
                numero1 = numero1 + "6"
            } else {
                numero2 = numero2 + "6"
            }
        }
        siete.setOnClickListener {
            if (b == 1) {
                numero1 = numero1 + "7"
            } else {
                numero2 = numero2 + "7"
            }
        }
        ocho.setOnClickListener {
            if (b == 1) {
                numero1 = numero1 + "8"
            } else {
                numero2 = numero2 + "8"
            }
        }
        nueve.setOnClickListener {
            if (b == 1) {
                numero1 = numero1 + "9"
            } else {
                numero2 = numero2 + "9"
            }
        }
        cero.setOnClickListener {
            if (b == 1) {
                numero1 = numero1 + "0"
            } else {
                numero2 = numero2 + "0"
            }
        }

        sum.setOnClickListener {
            b = 2
            operation = "sum"
        }
        res.setOnClickListener {
            b = 2
            operation = "res"
        }
        mul.setOnClickListener {
            b = 2
            operation = "mul"
        }
        div.setOnClickListener {
            b = 2
            operation = "div"
        }
        equal.setOnClickListener {
            if (b == 2) {
                num1 = numero1.toInt()
                num2 = numero2.toInt()
                op = "{ operation : " + operation + ", num1 : " + num1 + ", num2 : " + num2 + "}"
                numero1 = ""
                numero2 = ""

            }
            if (b == 1)
            {
                num1 = numero1.toInt()
                num2 = 0
                op = "{ operation : " + operation + "num1 : " + num1 + "num2 : " + num2 + "}"
                println(op)
                numero1 = ""
                numero2 = ""
            }
            if (b == 1 && numero1 == " ")
            {
                num1 = 0
                num2 = 0
                op = "{ operation : " + operation + "num1 : " + num1 + "num2 : " + num2 + "}"
                println(op)
                numero1 = ""
                numero2 = ""
            }

            Fuel.post("http://httpbin.org/post").body("{ \"operation\" : "+ operation + "\"num1\" : " + num1 + "\"num2\" : " + num2 +" }" ).response { request, response, result ->
                when(result){
                    is Result.Success -> { Toast.makeText(this, "yes", Toast.LENGTH_SHORT).show()  }
                    is Result.Failure -> { Toast.makeText(this, "Error de conexión", Toast.LENGTH_SHORT).show() }
                }
            }

        }
    }
}
