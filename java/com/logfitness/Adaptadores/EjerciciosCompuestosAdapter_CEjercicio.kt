package com.logfitness.Adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.logfitness.BBDD.BDCategorias
import com.logfitness.Entidades.Categoria
import com.logfitness.Entidades.EjercicioCompuesto
import com.logfitness.R

class EjerciciosCompuestosAdapter_CEjercicio(val contexto: Context, val listaCategorias: MutableList<EjercicioCompuesto>) :
    RecyclerView.Adapter<EjerciciosCompuestosAdapter_CEjercicio.ECompuestoViewHolder>() {
    val bdCat : BDCategorias = BDCategorias(contexto)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ECompuestoViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_ejercicio_compuesto, null, false)
        return ECompuestoViewHolder(view)
    }
    init {
        if (listaCategorias.size == 0) {
            listaCategorias.add(EjercicioCompuesto("",100))
        }
    }
    override fun onBindViewHolder(
        holder: ECompuestoViewHolder,
        position: Int
    ) {
        val adapter: ArrayAdapter<Categoria> = ArrayAdapter(contexto, android.R.layout.simple_spinner_item, bdCat.getCategorias());
        holder.nombre_ejercicio_compuesto.adapter = adapter
    }

    override fun getItemCount(): Int {
        return listaCategorias.size
    }
    class ECompuestoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nombre_ejercicio_compuesto = itemView.findViewById<Spinner>(R.id.sp_nombre_categoria_ejcompuesto)
        var porcentaje = itemView.findViewById<TextView>(R.id.ed_porcetaje_categoria)


    }
}