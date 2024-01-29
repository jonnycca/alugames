package br.com.teste.alugames.model

import formatoComDuasCasasDecimais
import java.math.BigDecimal
import java.math.RoundingMode

class PlanoAssinatura(
    tipo:String,
    val mensalidade: Double,
    val jogoInclusidos: Int,
    val percentualDescontoReputacao: BigDecimal):Plano(tipo){

    override fun obterValor(aluguel: Aluguel): BigDecimal {
        val totalJogosMes = aluguel.gamer.getJogosPorMes(aluguel.periodo.dataInicial.monthValue)

        return if(totalJogosMes.size+1 <= jogoInclusidos){
            BigDecimal("0.0")
        }else{
            var valorOriginal = super.obterValor(aluguel)
            if (aluguel.gamer.media > 8){
                valorOriginal -= valorOriginal.multiply(percentualDescontoReputacao)
            }
            valorOriginal.setScale(2, RoundingMode.HALF_EVEN)
        }
    }
}
