package br.com.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class CarteiraDigital {
    private List<Cartao> cartoes;

    public CarteiraDigital() {
        cartoes = new ArrayList<>();
    }

    // Adiciona um novo cartão, evitando duplicados pelo número
    public boolean adicionarCartao(Cartao cartao) {
        if (buscarCartaoPorNumero((String) cartao.getNumero()) != null) {
            return false; // já existe
        }
        cartoes.add(cartao);
        return true;
    }

    // Remove cartão pelo número
    public boolean removerCartao(String numero) {
        Cartao c = buscarCartaoPorNumero(numero);
        if (c != null) {
            cartoes.remove(c);
            return true;
        }
        return false;
    }

    // Retorna todos os cartões
    public List<Cartao> getCartoes() {
        return new ArrayList<>(cartoes); // evita acesso direto à lista
    }

    // Busca cartão pelo número
    public Cartao buscarCartaoPorNumero(String numero) {
        for (Cartao c : cartoes) {
            if (c.getNumero().equals(numero)) {
                return c;
            }
        }
        return null;
    }
}
