package br.com.teste.alugames.model

class PlanoAssinatura(
    tipo:String,
    val mensalidade: Double,
    val jogoInclusidos: Int):Plano(tipo){

    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosMes = aluguel.gamer.getJogosPorMes(aluguel.periodo.dataInicial.monthValue)

        return if(totalJogosMes.size+1 <= jogoInclusidos){
            0.0
        }else{
            super.obterValor(aluguel)
        }
    }
}
