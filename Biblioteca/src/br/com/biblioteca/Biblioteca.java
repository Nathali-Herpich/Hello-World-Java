package br.com.biblioteca;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Classe principal que gerencia os livros, usuários e empréstimos da biblioteca
public class Biblioteca {

    // Lista de livros disponíveis na biblioteca
    private List<Livro> livros;

    // Lista de usuários cadastrados
    private List<Usuario> usuarios;

    // Construtor: inicializa as listas de livros e usuários
    public Biblioteca() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    // Método para adicionar um novo livro ao sistema
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    // Método para adicionar um novo usuário ao sistema
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Busca um livro pelo ISBN
    public Livro buscarLivroPorIsbn(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null; // Não encontrado
    }

    // Busca um usuário pelo CPF
    public Usuario buscarUsuarioPorCpf(String cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null; // Não encontrado
    }

    // Realiza o empréstimo de um livro
    public boolean emprestarLivro(String isbn, String cpf, int dias) {
        Livro livro = buscarLivroPorIsbn(isbn);
        Usuario usuario = buscarUsuarioPorCpf(cpf);

        // Verifica se o livro e o usuário existem e se o livro está disponível
        if (livro != null && usuario != null && livro.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(livro, usuario, dias);
            livro.setDisponivel(false); // Marca o livro como emprestado
            usuario.adicionarEmprestimo(emprestimo); // Adiciona o empréstimo ao usuário
            System.out.println("Empréstimo realizado com sucesso!");
            return true;
        } else {
            System.out.println("Erro: livro indisponível ou dados inválidos.");
            return false;
        }
    }

    // Realiza a devolução de um livro
    public void devolverLivro(String isbn, String cpf) {
        Usuario usuario = buscarUsuarioPorCpf(cpf);

        if (usuario != null) {
            // Percorre os empréstimos do usuário
            for (Emprestimo e : usuario.getEmprestimos()) {
                // Verifica se é o livro certo e se ainda está ativo
                if (Objects.equals(e.getLivro().getIsbn(), isbn))
                    if (e.isAtivo()) {
                        e.devolverLivro(); // Marca como devolvido
                        System.out.println("Livro devolvido com sucesso.");
                        return;
                    }
            }
        }

        System.out.println("Erro: empréstimo não encontrado.");
    }

    // Lista todos os livros cadastrados no sistema
    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        System.out.println("--- Lista de Livros ---");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }
}
