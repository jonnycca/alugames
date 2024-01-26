package br.com.teste.alugames.model

import org.example.br.com.teste.alugames.model.Jogo

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo){

    private var valorDoAlguel = gamer.plano.obterValor(this)
    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.nome} pelo valor $valorDoAlguel"
    }
}
