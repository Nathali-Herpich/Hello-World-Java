package br.com.biblioteca;


// Classe que representa um livro na biblioteca
public class Livro {
    // Atributos do livro
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponivel; // Indica se o livro está disponível para empréstimo

    // Construtor para criar um livro com título, autor e ISBN
    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true; // Livro começa disponível por padrão
    }

    // Getters e setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    // ISBN normalmente não muda, então não precisa de setter

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    // Método para mostrar as informações do livro em formato amigável
    @Override
    public String toString() {
        return "Livro{" +
                "Título='" + titulo + '\'' +
                ", Autor='" + autor + '\'' +
                ", ISBN='" + isbn + '\'' +
                ", Disponível=" + (disponivel ? "Sim" : "Não") +
                '}';
    }
}

