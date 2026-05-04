package Caixa1;
public interface ICaixaEletronico {

    String pegaRelatorioCedulas();

    String pegaValorTotalDisponivel();

    String reposicaoCedulas(Integer cedula, Integer quantidade);

    String sacar(Integer valor);

    String armazenaCotaMinima(Integer minimo);
}