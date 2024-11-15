package com.example.proyectopractica

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Calculadora : AppCompatActivity() {

    private lateinit var boton : Button
    private lateinit var boton2 : Button
    private lateinit var operaciones : Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)


        boton = findViewById(R.id.regresar)
        boton2 = findViewById(R.id.resultado)
        operaciones = findViewById(R.id.operaciones)

        val operar = listOf("Suma", "Resta", "Multiplicar", "Dividir")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operar)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        operaciones.adapter = adapter

        boton.setOnClickListener {
            retornar()
        }

        boton2.setOnClickListener {
            calculadora()
        }
        val buttonNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        buttonNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.nav_home->{
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_profile->{
                    val intent = Intent(this, Calculadora::class.java)
                    startActivity(intent)
                    true
                }
                else-> {
                    false
                }
            }
        }
    }

    private fun retornar() {
        val intent = Intent(this, Home::class.java)
        startActivity(intent)
    }

    private fun calculadora(){
        val num1 = findViewById<EditText>(R.id.numero1)
        val num2 = findViewById<EditText>(R.id.numero2)
        val selectOperacion = findViewById<Spinner>(R.id.operaciones)

        val valor1 = num1.text.toString().toDoubleOrNull()
        val valor2 = num2.text.toString().toDoubleOrNull()

        if(valor1 == null || valor2 == null){
            Toast.makeText(this, "Por favor ingresa un numero", Toast.LENGTH_LONG).show()
            return
        }

        val operacionSeleccionada = selectOperacion.selectedItem.toString()

        val resultado  =  when(operacionSeleccionada){
            "Suma"-> sumar(valor1, valor2)
            "Resta"->restar(valor1,valor2)
            "Multiplicar"->multiplicar(valor1,valor2)
            "Dividir"->dividir(valor1,valor2)

            else->0.0
        }
        val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)

        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialog_title)
        val dialogMessage = dialogView.findViewById<TextView>(R.id.dialog_message)

        dialogTitle.text = operacionSeleccionada

        dialogMessage.text="Resultado: $resultado"

        val builder = AlertDialog.Builder(this)

        builder.setView(dialogView)

        val dialog = builder.create()

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()

        val btnCancelar = dialogView.findViewById<Button>(R.id.cancelar)
        val btnAceptar = dialogView.findViewById<Button>(R.id.aceptar)

        btnCancelar.setOnClickListener{
            dialog.dismiss()
        }

        btnAceptar.setOnClickListener{
            dialog.dismiss()
        }
    }

    private fun sumar(numero1:Double, numero2:Double):Double{
        return numero1 + numero2
    }
    private fun restar(numero1:Double, numero2:Double):Double{
        return numero1 - numero2
    }
    private fun multiplicar(numero1:Double, numero2:Double):Double{
        return numero1 * numero2
    }
    private fun dividir(numero1:Double, numero2:Double):Double{
        return numero1 / numero2
    }

}