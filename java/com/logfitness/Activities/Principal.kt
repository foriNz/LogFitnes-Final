package com.logfitness.Activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.logfitness.BBDD.BDEjercicios
import com.logfitness.R

class Principal (): AppCompatActivity() {

    //var adapter : ListaEjerciciosAdapter_PP?




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        val recyclerView: RecyclerView? = findViewById(R.id.rvLista_ejercicios)
        val btn_crear: Button = findViewById(R.id.btn_nuevo_ejercicio_pp)
        val btn_calendario: Button = findViewById(R.id.btn_calendario_pp)
        val tv_fecha: TextView = findViewById(R.id.tv_fecha_pp)
        btn_crear.setOnClickListener {
            startActivity(Intent(baseContext, BuscadorEjercicio::class.java))


        }
    }


}