package com.skyalert.ernestovm.kotlinproject

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

data class cursos(val nombre: String, val url: String)

class AprendiendoKotlin : Activity() {

    val react = cursos("React", "react")
    val kotlin = cursos("Kotlin","kotlin")
    var cursoActual = react.copy()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aprendiendo_kotlin)

        val boton = findViewById<Button>(R.id.btn1) as Button
        boton.setOnClickListener{
            view -> switchCurso(cursoActual)
        }
        boton.text = todosLosCursos()
    }

    fun switchCurso(curso: cursos){
        cursoActual = curso.copy()
        when (curso.url){
            "react" -> cursoActual = kotlin.copy()
            "kotlin" -> cursoActual = react.copy()
            else -> print("esto no va a pasar")
        }
        mostrarEnPantalla("Curso de ${cursoActual.nombre} en android.com/${cursoActual.url}")
    }

    fun mostrarEnPantalla(s: String){
        val txt = findViewById<View>(R.id.mensaje) as TextView
        txt.text = s
    }

    fun todosLosCursos():String = "${react.nombre} y ${kotlin.nombre}"
}
