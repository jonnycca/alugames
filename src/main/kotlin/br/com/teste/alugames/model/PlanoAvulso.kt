package br.com.teste.alugames.model

import formatoComDuasCasasDecimais
import java.math.BigDecimal

class PlanoAvulso(tipo: String, id:Int) : Plano(tipo, id){
    override fun obterValor(aluguel: Aluguel): BigDecimal {
        var valorOriginal = super.obterValor(aluguel)
        if (aluguel.gamer.media > 8){
            valorOriginal -= valorOriginal.multiply(BigDecimal("0.1"))
        }
        return valorOriginal
    }

    override fun toString(): String {
        return "Plano Avulso\n" +
                "Tipo: $tipo\n" +
                "Id: $id\n"
    }
}
