package Caixa1;
public class CaixaEletronico implements ICaixaEletronico {

    private int n2 = 0, n5 = 0, n10 = 0, n20 = 0, n50 = 0, n100 = 0;
    private int cotaMinima = 0;

    private int calcularTotal() {
        return n2*2 + n5*5 + n10*10 + n20*20 + n50*50 + n100*100;
    }

    public String pegaRelatorioCedulas() {
        return "Cédulas disponíveis:\n" +
                "2: " + n2 + "\n" +
                "5: " + n5 + "\n" +
                "10: " + n10 + "\n" +
                "20: " + n20 + "\n" +
                "50: " + n50 + "\n" +
                "100: " + n100 + "\n";
    }

    public String pegaValorTotalDisponivel() {
        return "Total disponível: R$ " + calcularTotal();
    }

    public String reposicaoCedulas(Integer cedula, Integer quantidade) {
        if (cedula == null || quantidade == null || quantidade <= 0) {
            return "Quantidade ou cédula inválida";
        }

        switch (cedula) {
            case 2: n2 += quantidade; break;
            case 5: n5 += quantidade; break;
            case 10: n10 += quantidade; break;
            case 20: n20 += quantidade; break;
            case 50: n50 += quantidade; break;
            case 100: n100 += quantidade; break;
            default: return "Cédula inválida";
        }

        return "Reposição realizada com sucesso";
    }

    public String sacar(Integer valor) {
        if (valor == null || valor <= 0) {
            return "Valor inválido";
        }

        int total = calcularTotal();

        if (total <= cotaMinima) {
            return "Caixa abaixo da cota mínima";
        }

        if (total < valor) {
            return "Saldo insuficiente";
        }

        for (int s100 = Math.min(valor / 100, n100); s100 >= 0; s100--) {
            for (int s50 = Math.min(valor / 50, n50); s50 >= 0; s50--) {
                for (int s20 = Math.min(valor / 20, n20); s20 >= 0; s20--) {
                    for (int s10 = Math.min(valor / 10, n10); s10 >= 0; s10--) {
                        for (int s5 = Math.min(valor / 5, n5); s5 >= 0; s5--) {
                            for (int s2 = Math.min(valor / 2, n2); s2 >= 0; s2--) {

                                int soma =
                                        s100 * 100 +
                                        s50 * 50 +
                                        s20 * 20 +
                                        s10 * 10 +
                                        s5 * 5 +
                                        s2 * 2;

                                if (soma == valor) {

                                    n100 -= s100;
                                    n50 -= s50;
                                    n20 -= s20;
                                    n10 -= s10;
                                    n5 -= s5;
                                    n2 -= s2;

                                    return "Saque realizado com sucesso\n" +
                                            "Notas entregues:\n" +
                                            "100: " + s100 + "\n" +
                                            "50: " + s50 + "\n" +
                                            "20: " + s20 + "\n" +
                                            "10: " + s10 + "\n" +
                                            "5: " + s5 + "\n" +
                                            "2: " + s2 + "\n";
                                }
                            }
                        }
                    }
                }
            }
        }

        return "Não é possível formar o valor com as cédulas disponíveis";
    }

    public String armazenaCotaMinima(Integer minimo) {
        if (minimo == null || minimo < 0) {
            return "Valor inválido";
        }

        cotaMinima = minimo;
        return "Cota mínima definida: R$ " + minimo;
    }

    public static void main(String[] args) {
        new GUI().setVisible(true);
    }
}