package com.logfitness.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TableLayout
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.logfitness.Activities.Dialogos.CreacionCategoria
import com.logfitness.R

class CreacionEjercicio : AppCompatActivity() {
    var dialogo_nueva_categoria: CreacionCategoria? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creacion_ejercicio)
        val searchView: SearchView = findViewById(R.id.sv_buscador_ejercicio_padre)
        searchView.queryHint = resources.getString(R.string.hint_buscador_ejercicio_padre)
        val editText: EditText = findViewById(R.id.et_titulo_ejercicio)
        val spinner_categoria: Spinner = findViewById(R.id.sp_categoria)
        val nueva_categoria: Button = findViewById(R.id.btn_nueva_categoria_CE)
        val ayuda_ejercicio_padre: Button = findViewById(R.id.btn_ayuda_ejercicio_padre)
        val spinner_ejercicio_padre: Spinner = findViewById(R.id.sp_ejercicio_padre)
        val ejercicio_compuesto: CheckBox = findViewById(R.id.cb_ejercicio_compuesto)
        val ayuda_ejercicio_compuesto: Button = findViewById(R.id.btn_ayuda_ejercicio_compuesto)
        val ejercicios_compuestos: TableLayout = findViewById(R.id.tl_ejercicios_compuestos)

        nueva_categoria.setOnClickListener({abrirNuevaCategoria()})
    }
    private fun abrirNuevaCategoria() {
        val dialogo = CreacionCategoria()
        dialogo_nueva_categoria = dialogo
        dialogo_nueva_categoria!!.isCancelable = false
        dialogo_nueva_categoria!!.show(supportFragmentManager,"dialogo_categoria")
    }
    private fun refrescarSpinnerCategorias(spinner: Spinner) {
        spinner
    }
}