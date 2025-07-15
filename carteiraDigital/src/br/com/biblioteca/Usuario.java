package br.com.biblioteca;

import java.util.List;

public class Usuario {
    private String login;
    private String senha;
    private double saldo;
    private double extrato;
    private List<Cartao> cartoes;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.saldo = 0.0;
        this.extrato = 0.0;
    }

    public boolean senhaCorreta(String senha) {
        return false;
    }

    public void depositar(double valor) {
    }

    public boolean pagar(double valor) {
        return false;
    }

    public String[] getExtrato() {
        return null;
    }

    public Cartao[] getCartoes() {
        return null;
    }

    public void adicionarCartao(Cartao novo) {
    }

    public Object getSaldo() {
        return null;
    }
}

