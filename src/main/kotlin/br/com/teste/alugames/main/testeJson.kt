package br.com.teste.alugames.main

import br.com.teste.alugames.model.Periodo
import br.com.teste.alugames.model.PlanoAssinatura
import br.com.teste.alugames.services.ConsumoArquivoService
import java.time.LocalDate

fun main(){
    val consumo = ConsumoArquivoService()
    val listaGamers = consumo.buscaGamers()
    val listaJogos = consumo.buscaJogos()

    val gamer = listaGamers[0]
    val gamer2 = listaGamers[1]
    val jogo = listaJogos[0]
    val jogo2 = listaJogos[1]
    val jogo3 = listaJogos[10]
    val jogo4 = listaJogos[13]
    val jogo5 = listaJogos[2]
    val jogo6 = listaJogos[5]
    val jogo7 = listaJogos[4]
    val jogo8 = listaJogos[6]
    val jogo9 = listaJogos[7]
    val jogo10 = listaJogos[18]


    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    gamer.alugaJogo(jogo, periodo)
    gamer.alugaJogo(jogo2, periodo)

//    println(gamer.jogosAlugados)

    gamer2.plano = PlanoAssinatura("PRATA", 9.90, 1, 0.15)

    gamer2.alugaJogo(jogo, periodo)
    gamer2.alugaJogo(jogo2, periodo)

    println(gamer2.jogosAlugados)


    gamer.recomendar(11)

    gamer.recomendar(10)

    println(gamer)

    gamer.alugaJogo(jogo, periodo)
    println(gamer.jogosAlugados)

    gamer.recomendarJogo(jogo, 10)
    gamer.recomendarJogo(jogo2, 1)
    gamer.recomendarJogo(jogo3, 7)
    gamer.recomendarJogo(jogo4, 10)
    gamer.recomendarJogo(jogo5, 8)
    gamer.recomendarJogo(jogo6, 7)
    gamer.recomendarJogo(jogo7, 10)
    gamer.recomendarJogo(jogo8, 8)
    gamer.recomendarJogo(jogo9, 8)
    gamer.recomendarJogo(jogo10, 6)


    println("Jogos recomendados!")
    println(gamer.jogosRecomendados)
}