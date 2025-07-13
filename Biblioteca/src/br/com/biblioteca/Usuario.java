package br.com.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

        // Atributos principais do usuário
        private String nome;
        private String cpf;
        private List<Emprestimo> emprestimos; // Lista de empréstimos feitos por esse usuário

        // Construtor: recebe nome e CPF ao criar o objeto
        public Usuario(String nome, String cpf) {
            this.nome = nome;
            this.cpf = cpf;
            this.emprestimos = new ArrayList<>(); // Cria a lista vazia de empréstimos
        }

        // Getters (e setters se desejar adicionar no futuro)
        public String getNome() {
            return nome;
        }

        public String getCpf() {
            return cpf;
        }

        // Retorna a lista de empréstimos do usuário
        public List<Emprestimo> getEmprestimos() {
            return emprestimos;
        }

        // Adiciona um novo empréstimo à lista do usuário
        public void adicionarEmprestimo(Emprestimo emprestimo) {
            emprestimos.add(emprestimo);
        }

        // Mostra as informações do usuário de forma legível
        @Override
        public String toString() {
            return "Usuário{" +
                    "Nome='" + nome + '\'' +
                    ", CPF='" + cpf + '\'' +
                    ", Empréstimos Ativos=" + contarEmprestimosAtivos() +
                    '}';
        }

        // Conta quantos empréstimos ainda estão ativos (não devolvidos)
        private int contarEmprestimosAtivos() {
            int contador = 0;
            for (Emprestimo e : emprestimos) {
                if (e.isAtivo()) {
                    contador++;
                }
            }
            return contador;
        }
    }
