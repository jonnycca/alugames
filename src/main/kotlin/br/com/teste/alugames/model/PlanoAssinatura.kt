package br.com.teste.alugames.model

import formatoComDuasCasasDecimais

class PlanoAssinatura(
    tipo:String,
    val mensalidade: Double,
    val jogoInclusidos: Int,
    val percentualDescontoReputacao: Double):Plano(tipo){

    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosMes = aluguel.gamer.getJogosPorMes(aluguel.periodo.dataInicial.monthValue)

        return if(totalJogosMes.size+1 <= jogoInclusidos){
            0.0
        }else{
            var valorOriginal = super.obterValor(aluguel)
            if (aluguel.gamer.media > 8){
                valorOriginal -= valorOriginal * percentualDescontoReputacao
            }
            valorOriginal.formatoComDuasCasasDecimais()
        }
    }
}
