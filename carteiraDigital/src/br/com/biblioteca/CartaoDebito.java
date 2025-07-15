package br.com.biblioteca;

public class CartaoDebito extends Cartao {
    private double saldo;

    public CartaoDebito(String numero, String titular, double saldo) {
        super(numero, titular);
        this.saldo = saldo;
    }

    @Override
    public String getTipo() {
        return "Débito";
    }

    @Override
    public double getSaldo() {
        return saldo;
    }
}

