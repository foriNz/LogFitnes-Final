package com.logfitness.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.logfitness.R

class BuscadorEjercicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscador_ejercicio)
        val nuevo_ejercicio: Button = findViewById(R.id.btn_nuevoEjercicio_BE)
        nuevo_ejercicio.setOnClickListener({startActivity(Intent(baseContext, CreacionEjercicio::class.java)) })
    }

}