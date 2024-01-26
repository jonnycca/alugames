package br.com.teste.alugames.services

import br.com.teste.alugames.model.Gamer
import br.com.teste.alugames.model.InfoGamerJson
import br.com.teste.alugames.model.InfoJogoJson
import br.com.teste.alugames.utilitario.criaJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import criaGamer
import org.example.br.com.teste.alugames.model.Jogo
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

class ConsumoArquivoService {

    fun buscaJogos():List<Jogo>{
        val arquivoJson = lerArquivoJson("src/main/resources/jogos.json")

        val gson = Gson()
        val meuJogoTipo = object : TypeToken<List<InfoJogoJson>>() {}.type

        val listaJogo: List<InfoJogoJson> = gson.fromJson(arquivoJson, meuJogoTipo)

        val listaJogoConvertida = listaJogo.map { infoJogoJson -> infoJogoJson.criaJogo() }
        return listaJogoConvertida
    }

    fun buscaGamers(): List<Gamer>{
        val arquivoJson = lerArquivoJson("src/main/resources/gamers.json")

        val gson = Gson()
        val meuGamerTipo = object : TypeToken<List<InfoGamerJson>>(){}.type
        val listGamers: List<InfoGamerJson> = gson.fromJson(arquivoJson, meuGamerTipo)

        val listaGamerConvertida = listGamers.map { infoGamerJson ->
            infoGamerJson.criaGamer()
        }
        return listaGamerConvertida
    }


    private fun lerArquivoJson(arquivo:String):String{
        val json = java.lang.String.join(
            " ",
            Files.readAllLines(
                Paths.get(arquivo),
                StandardCharsets.UTF_8
            )
        )

        return json
    }
}