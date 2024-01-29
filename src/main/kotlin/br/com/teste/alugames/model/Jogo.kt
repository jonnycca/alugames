package org.example.br.com.teste.alugames.model

import br.com.teste.alugames.model.Recomendavel
import com.google.gson.annotations.Expose
import formatoComDuasCasasDecimais
import java.math.BigDecimal

data class Jogo(
    @Expose var titulo: String,
    @Expose val capa: String
) : Recomendavel {

    var descricao: String? = null

    var preco = BigDecimal(0.0)

    private val listaNotas = mutableListOf<Int>()
    override val media: Double
        get() = listaNotas.average().formatoComDuasCasasDecimais()


    constructor(titulo: String, capa: String, preco: BigDecimal, descricao: String) :
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override fun recomendar(nota: Int) {
        if (nota > 10 || nota < 1) {
            println("Nota $nota invalida")
        } else {
            listaNotas.add(nota)
        }
    }

    override fun toString(): String {
        return "Jogo(titulo='$titulo', capa='$capa', descricao='$descricao', preco= $preco," +
                "Reputacao= $media)"
    }
}