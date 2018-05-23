package com.example.hp.calcuator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        //En cada boton se le agrega la funcion de concatenar en la variable para almacenar los numeros que se ingresen. Inicialmente se almacena una cadena.
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
        //Cuando un operador es seleccionado, se inicia almacena este operador y se cambia la variable "semaforo" b para iniciar el registro del segundo numero.
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

        //Cuando los numeros son almacenados, y se desea realizar la operación, se presiona = y se envía la operación al servidor. Para esto, se usan las variables string y se le aplica la funcion toInt() y se guarda en otra variable de tipo entero.
        equal.setOnClickListener {
            if (b == 2) {
                num1 = numero1.toInt()
                num2 = numero2.toInt()
                op = "{ operation : " + operation + ", num1 : " + num1 + ", num2 : " + num2 + "}"
                numero1 = " "
                numero2 = " "

            }
            if (b == 1)
            {
                //Si no se agrega nada al segundo numero, se iguala a 0.
                num1 = numero1.toInt()
                num2 = 0
                op = "{ operation : " + operation + "num1 : " + num1 + "num2 : " + num2 + "}"
                println(op)
                numero1 = ""
                numero2 = ""
            }


        //Con fuel post se hace la peticion al servidor, enviandole los numeros como parametros en una lista.
            Fuel.post("http://parcial.getsandbox.com/operation", listOf("operation" to operation, "num1" to num1, "num2" to num2)).responseString { request, response, result ->
                when(result){
                    is Result.Success -> { Toast.makeText(this, "${result.get()}", Toast.LENGTH_SHORT).show() }
                    is Result.Failure -> { Toast.makeText(this, "Error de conexión", Toast.LENGTH_SHORT).show() }
                }
            }

        }
    }
}
