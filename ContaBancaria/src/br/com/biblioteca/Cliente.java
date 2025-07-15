package br.com.biblioteca;

public class Cliente {
    private String nome;
    private String tipoDeConta;
    private double saldoInicial;

    public Cliente (String nathaliherpich, String nome, double v) {
        this.nome = nome;
        this.tipoDeConta = tipoDeConta;
        this.saldoInicial = saldoInicial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipoDeConta(String tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public void setDepositaValor (double deposito) {
        saldoInicial += deposito;
        System.out.println(getExtrato());
    }

    public void setSaqueValor (double saque) {
        if (saldoInicial - saque >= 0) {
            saldoInicial -= saque;
            System.out.println(getExtrato());
        } else {
            System.out.println("Saldo insuficiente para o saque.");
            System.out.println(getExtrato());
        }

    }

    public String getExtrato () {
        return String.format("O saldo atualizado em %s é R$%.2f.\n========================\n", tipoDeConta, saldoInicial);
    }

    @Override
    public String toString() {
        return """
                **************************
                DADOS INICIAIS DO CLIENTE:
                =========================
                NOME: %s.
                TIPO DE CONTA: %s.
                SALDO INICIAL: R$%.2f.
                """.formatted(nome, tipoDeConta, saldoInicial);
    }
}
