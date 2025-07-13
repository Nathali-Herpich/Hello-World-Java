package br.com.biblioteca;

import br.com.biblioteca.Livro;
import br.com.biblioteca.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Classe que representa um empréstimo de um livro para um usuário
public class Emprestimo {
    private Livro livro;              // Livro emprestado
    private Usuario usuario;         // Usuário que fez o empréstimo
    private LocalDate dataEmprestimo; // Data em que o livro foi emprestado
    private LocalDate dataDevolucao;  // Data prevista para devolução
    private boolean ativo;            // Indica se o empréstimo ainda está ativo

    // Construtor: cria um novo empréstimo com prazo em dias
    public Emprestimo(Livro livro, Usuario usuario, int diasDePrazo) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now(); // Pega a data atual
        this.dataDevolucao = dataEmprestimo.plusDays(diasDePrazo); // Soma os dias de prazo
        this.ativo = true; // Empréstimo começa como ativo
    }

    // Método chamado ao devolver o livro
    public void devolverLivro() {
        this.ativo = false; // Marca como finalizado
        livro.setDisponivel(true); // Torna o livro disponível novamente
    }

    // Getters
    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    // Exibe as informações do empréstimo
    @Override
    public String toString() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "Empréstimo{" +
                "Livro='" + livro.getTitulo() + '\'' +
                ", Usuário='" + usuario.getNome() + '\'' +
                ", Data de Empréstimo=" + dataEmprestimo.format(formatador) +
                ", Data de Devolução=" + dataDevolucao.format(formatador) +
                ", Ativo=" + (ativo ? "Sim" : "Não") +
                '}';
    }
}