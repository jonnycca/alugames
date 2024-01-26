package br.com.teste.alugames.main

import br.com.teste.alugames.model.Periodo
import br.com.teste.alugames.services.ConsumoArquivoService
import java.time.LocalDate

fun main(){
    val consumo = ConsumoArquivoService()
    val listaGamers = consumo.buscaGamers()
    val listaJogos = consumo.buscaJogos()

    val gamer = listaGamers[0]
    val jogo = listaJogos[0]
    val jogo2 = listaJogos[2]


    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    gamer.alugaJogo(jogo, periodo)
    gamer.alugaJogo(jogo2, periodo)


    print(gamer.getJogosPorMes(7))



}