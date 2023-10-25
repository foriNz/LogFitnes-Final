package com.logfitness.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TableLayout
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.logfitness.Activities.Dialogos.CreacionCategoria
import com.logfitness.BBDD.BDCategorias
import com.logfitness.Entidades.Categoria
import com.logfitness.R

class CreacionEjercicio : AppCompatActivity() {
    var dialogo_nueva_categoria: CreacionCategoria? = null
    var editText: EditText? = null
    var spinner_categoria: Spinner? = null

    var ayuda_ejercicio_padre: Button? = null
    var spinner_ejercicio_padre: Spinner? = null
    var ejercicio_compuesto: CheckBox? = null
    var ayuda_ejercicio_compuesto: Button? = null
    var ejercicios_compuestos: TableLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creacion_ejercicio)
        val searchView: SearchView = findViewById(R.id.sv_buscador_ejercicio_padre)
        searchView.queryHint = resources.getString(R.string.hint_buscador_ejercicio_padre)
        editText = findViewById(R.id.et_titulo_ejercicio)
        spinner_categoria = findViewById(R.id.sp_categoria)
        val nueva_categoria: Button = findViewById(R.id.btn_nueva_categoria_CE)
        ayuda_ejercicio_padre = findViewById(R.id.btn_ayuda_ejercicio_padre)
        spinner_ejercicio_padre = findViewById(R.id.sp_ejercicio_padre)
        ejercicio_compuesto = findViewById(R.id.cb_ejercicio_compuesto)
        ayuda_ejercicio_compuesto = findViewById(R.id.btn_ayuda_ejercicio_compuesto)
        ejercicios_compuestos = findViewById(R.id.tl_ejercicios_compuestos)

        nueva_categoria.setOnClickListener({ abrirNuevaCategoria() })
        refrescarSpinnerCategorias()
    }

    private fun abrirNuevaCategoria() {
        val dialogo = CreacionCategoria()
        dialogo_nueva_categoria = dialogo
        dialogo_nueva_categoria!!.isCancelable = false
        dialogo_nueva_categoria!!.show(supportFragmentManager, "dialogo_categoria")
    }

    public fun refrescarSpinnerCategorias() {
        val bd = BDCategorias(this)
        val adapter =
            ArrayAdapter<Categoria>(this, android.R.layout.simple_spinner_item, bd.getCategorias())
        spinner_categoria!!.adapter = adapter
    }
}