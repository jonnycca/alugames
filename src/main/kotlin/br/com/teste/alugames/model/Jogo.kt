package org.example.br.com.teste.alugames.model

import br.com.teste.alugames.model.Recomendavel

data class Jogo (var titulo: String,
            val capa : String):Recomendavel{

    var descricao:String? = null

    var preco = 0.0

    private val listaNotas = mutableListOf<Int>()
    override val media: Double
        get() = listaNotas.average()


    constructor(titulo: String, capa: String, preco: Double, descricao: String):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override fun recomendar(nota: Int) {
        if (nota >10 || nota < 1){
            println("Nota $nota invalida")
        }else{
            listaNotas.add(nota)
        }
    }

    override fun toString(): String {
        return "Jogo(titulo='$titulo', capa='$capa', descricao='$descricao', preco= $preco," +
                "Reputacao= $media)"
    }
}