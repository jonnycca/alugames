import br.com.teste.alugames.model.Gamer
import br.com.teste.alugames.model.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
   return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}