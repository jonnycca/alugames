package br.com.teste.alugames.utilitario

import br.com.teste.alugames.model.InfoJogoJson
import org.example.br.com.teste.alugames.model.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}