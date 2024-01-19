package br.com.teste.alugames.main

import br.com.teste.alugames.model.Gamer

fun main(){
    val gamer = Gamer("Joao", "joao@gmail.com")

    println(gamer)

    val gamer2 = Gamer("Jose", "jose@gmail.com", "15/15/1992", "jose")

    println(gamer2)

    gamer.let {
        it.dataNascimento = "01/01/2000"
        it.usuario = "jao"
    }




    println(gamer.idInterno)

}