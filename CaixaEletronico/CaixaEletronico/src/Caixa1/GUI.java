package Caixa1;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private CaixaEletronico caixa = new CaixaEletronico();

    private JTextField valor = new JTextField(10);
    private JTextField cedula = new JTextField(5);
    private JTextField qtd = new JTextField(5);
    private JTextArea saida = new JTextArea(15, 30);

    public GUI() {

        setTitle("Caixa Eletrônico");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Valor:"));
        add(valor);

        add(new JLabel("Cédula:"));
        add(cedula);

        add(new JLabel("Quantidade:"));
        add(qtd);

        JButton depositar = new JButton("Depositar");
        JButton sacar = new JButton("Sacar");
        JButton saldo = new JButton("Saldo");
        JButton relatorio = new JButton("Cédulas");
        JButton sair = new JButton("Sair");

        add(depositar);
        add(sacar);
        add(saldo);
        add(relatorio);
        add(sair);

        sair.addActionListener(e -> {
            System.exit(0);
        });

        saida.setEditable(false);
        add(new JScrollPane(saida));

        depositar.addActionListener(e -> {
            try {
                saida.setText(caixa.reposicaoCedulas(
                        Integer.parseInt(cedula.getText()),
                        Integer.parseInt(qtd.getText())
                ));
            } catch (Exception ex) {
                saida.setText("Erro");
            }
        });

        sacar.addActionListener(e -> {
            try {
                saida.setText(caixa.sacar(
                        Integer.parseInt(valor.getText())
                ));
            } catch (Exception ex) {
                saida.setText("Erro");
            }
        });

        saldo.addActionListener(e ->
                saida.setText(caixa.pegaValorTotalDisponivel())
        );

        relatorio.addActionListener(e ->
                saida.setText(caixa.pegaRelatorioCedulas())
        );
    }
}