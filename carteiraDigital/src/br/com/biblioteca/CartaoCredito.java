package br.com.biblioteca;

public class CartaoCredito extends Cartao {
    private double limite;

    public CartaoCredito(String numero, String titular, double limite) {
        super(numero, titular);
        this.limite = limite;
    }

    @Override
    public String getTipo() {
        return "Crédito";
    }

    @Override
    public double getSaldo() {
        return limite;
    }
}

