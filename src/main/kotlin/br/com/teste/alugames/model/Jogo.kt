package org.example.br.com.teste.alugames.model

data class Jogo (var titulo: String,
            val capa : String,
            var descricao:String? = null){



    override fun toString(): String {
        return "Jogo(titulo='$titulo', capa='$capa', descricao='$descricao')"
    }
}