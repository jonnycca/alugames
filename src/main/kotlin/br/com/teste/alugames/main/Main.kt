package org.example.br.com.teste.alugames.main

import br.com.teste.alugames.model.Gamer
import br.com.teste.alugames.services.ConsumoApiService
import org.example.br.com.teste.alugames.model.Jogo
import transformarEmIdade
import java.util.*


fun main() {
    val leitura = Scanner(System.`in`)

    val gamer = Gamer.criarGamer(leitura)
    println("dados do gamer: ${gamer.toString()}" )

    println("Idade do gamer: ${gamer.dataNascimento?.transformarEmIdade()}")

    do {

        println("Digite o codigo do jogo:")
        val busca = leitura.nextLine()


        val buscaApiJogo = ConsumoApiService()
        val informacaoJogo = buscaApiJogo.buscaJogo(busca)


        var meuJogoMappead: Jogo? = null

        val resultado = runCatching {


            meuJogoMappead = Jogo(informacaoJogo.info.title, informacaoJogo.info.thumb, "")

            println(meuJogoMappead)
        }

        resultado.onFailure {
            println("Digite outro id")
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada? S/N")
            val opcao = leitura.nextLine()
            if (opcao.equals("s", true)) {
                println("insira a descricao personalizada para o jogo:")
                val descricao = leitura.nextLine()
                println("Descricao informada foi: $descricao")
                meuJogoMappead?.descricao = descricao
            }else{
                meuJogoMappead?.descricao = meuJogoMappead?.titulo
            }

            gamer.jogosBuscados.add(meuJogoMappead)

        }
        println("Deseja buscar um novo jogo? S/N")
        val resposta = leitura.nextLine()
    }while (resposta.equals("s", true))

    println("jogos buscados foram: ")
    println(gamer.jogosBuscados)

    println("\n jogos ordernados poor titulo")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach {
        println("Titulo: ${it?.titulo}")
    }

    val jogosFiltrado = gamer.jogosBuscados.filter {
        it?.titulo?.contains("Batman", true) ?: false
    }

    println("\njogos filtrados foram")
    println(jogosFiltrado)

    println("Deseja apagar algum jogo da lista original? S/N")
    val opcao = leitura.nextLine()

    if (opcao.equals("s", true)){
        println(gamer.jogosBuscados)
        println("Informe a posicao do jogo que deseja excluir: ")
        val posicao = leitura.nextInt()

        gamer.jogosBuscados.removeAt(posicao);
    }

    println("\n Lista atualizada")
    println(gamer.jogosBuscados)

    println("Busca finalizada com sucesso")

}