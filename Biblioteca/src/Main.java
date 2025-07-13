

import br.com.biblioteca.Biblioteca;
import br.com.biblioteca.Livro;
import br.com.biblioteca.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();


        biblioteca.adicionarLivro(new Livro("1984", "George Orwell", "001"));
        biblioteca.adicionarLivro(new Livro("Dom Casmurro", "Machado de Assis", "002"));
        
        biblioteca.adicionarUsuario(new Usuario("João", "12345678900"));
        biblioteca.adicionarUsuario(new Usuario("Maria", "98765432100"));

        int opcao;

        do {
            System.out.println("\n--- Menu Biblioteca ---");
            System.out.println("1. Listar livros");
            System.out.println("2. Emprestar livro");
            System.out.println("3. Devolver livro");
            System.out.println("4. Cadastrar novo usuário"); // ← Aqui estava faltando
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    biblioteca.listarLivros();
                    break;

                case 2:
                    System.out.print("ISBN do livro: ");
                    String isbn = scanner.nextLine();

                    System.out.print("CPF do usuário (11 dígitos): ");
                    String cpf = scanner.nextLine();

                    if (!cpf.matches("\\d{11}")) {
                        System.out.println("CPF inválido. Deve conter 11 números.");
                        break;
                    }

                    biblioteca.emprestarLivro(isbn, cpf, 7);
                    break;

                case 3:
                    System.out.print("ISBN do livro: ");
                    String isbnDev = scanner.nextLine();

                    System.out.print("CPF do usuário (11 dígitos): ");
                    String cpfDev = scanner.nextLine();

                    if (!cpfDev.matches("\\d{11}")) {
                        System.out.println("CPF inválido. Deve conter 11 números.");
                        break;
                    }

                    biblioteca.devolverLivro(isbnDev, cpfDev);
                    break;

                case 4:
                    System.out.print("Nome do novo usuário: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF (11 dígitos): ");
                    String novoCpf = scanner.nextLine();

                    if (!novoCpf.matches("\\d{11}")) {
                        System.out.println("CPF inválido. Deve conter 11 números.");
                        break;
                    }

                    if (biblioteca.buscarUsuarioPorCpf(novoCpf) != null) {
                        System.out.println("Já existe um usuário com esse CPF.");
                    } else {
                        Usuario novoUsuario = new Usuario(nome, novoCpf);
                        biblioteca.adicionarUsuario(novoUsuario);
                        System.out.println("Usuário cadastrado com sucesso!");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
