package org.example.br.com.teste.alugames.model

data class InfoJogo(val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}