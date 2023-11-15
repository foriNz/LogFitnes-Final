package com.logfitness.Adaptadores


import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.logfitness.Entidades.Ejercicio
import com.logfitness.R
import java.util.*
import java.util.stream.Collectors


class ListaEjerciciosAdapter_BE :
    RecyclerView.Adapter<ListaEjerciciosAdapter_BE.EjercicioViewHolder>() {
    var listaEjercicios: ArrayList<Ejercicio>? = null
    var listaOriginal: ArrayList<Ejercicio>? = null
    var contexto: Context? = null
    var datos: Bundle? = null

    fun ListaEjerciciosAdapter_BusquedaEjercicio(
        listaEjercicios: ArrayList<Ejercicio>?,
        context: Context?,
        datos: Bundle?
    ) {
        this.listaEjercicios = listaEjercicios
        this.contexto = context
        this.datos = datos
        listaOriginal = ArrayList()
        listaOriginal!!.addAll(listaEjercicios!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EjercicioViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ejercicio_buscador, null, false)
        return EjercicioViewHolder(view)
    }

    override fun onBindViewHolder(holder: EjercicioViewHolder, position: Int) {
        holder.viewNombre.setText(listaEjercicios!![position].nombreIU)
        holder.viewCategoria.text = listaEjercicios!![position].categoria.toString()
        holder.viewNombrePadre.text = listaEjercicios!![position].padre.toString()
    }

    fun filtrado(txtBuscar: String) {
        val longitud = txtBuscar.length
        if (longitud == 0) {
            listaEjercicios!!.clear()
            listaEjercicios!!.addAll(listaOriginal!!)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val collecion: List<Ejercicio> = listaEjercicios!!.stream()
                    .filter { i ->
                        i.nombreIU.lowercase()
                            .contains(txtBuscar.lowercase(Locale.getDefault()))
                    }
                    .collect(Collectors.toList())
                listaEjercicios!!.clear()
                listaEjercicios!!.addAll(collecion)
            } else {
                for (c in listaOriginal!!) {
                    if (c.nombreIU.lowercase()
                            .contains(txtBuscar.lowercase(Locale.getDefault()))
                    ) {
                        listaEjercicios!!.add(c)
                    }
                }
            }
        }
        //notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listaEjercicios!!.size
    }

    class EjercicioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var viewNombre: TextView
        var viewCategoria: TextView
        var viewNombrePadre: TextView

        init {
            viewNombre = itemView.findViewById<TextView>(R.id.tv_nombre_ejercicio_buscador)
            viewCategoria = itemView.findViewById(R.id.tv_categorias_buscador)
            viewNombrePadre = itemView.findViewById(R.id.tv_nombre_ejercicio_padre_buscador)
            itemView.setOnClickListener {
                /*
                val intent = Intent(contexto, NuevaSerie::class.java)
                intent.putExtra("nombre_ejercicio", viewNombre.text.toString())
                //intent.putExtra("fecha", datos.getInt("fecha"))
                contexto.startActivity(intent)
*/
            }
        }
    }
}