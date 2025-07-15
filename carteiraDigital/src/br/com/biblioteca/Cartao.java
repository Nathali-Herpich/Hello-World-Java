package br.com.biblioteca;

public abstract class Cartao {

    public Cartao(String bandeira, String numero, String validade) {
    }

    public Cartao(String numero, String titular) {
    }

    public Object getNumero() {
        return null;
    }

    public abstract String getTipo();

    public abstract double getSaldo();

    public String getTitular() {
        return null;
    }
}
