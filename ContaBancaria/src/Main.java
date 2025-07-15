import br.com.biblioteca.Cliente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Nathali Herpich", "Conta Corrente", 2000.00);
        int opcao = 0;


        while (opcao != 4) {
            //condição repetida

            System.out.println("""
                    Escolha:
                    
                    1 - Consultar Saldos
                    2 - Depósito
                    3 - Saque
                    4 - Sair
                    
                    Digite a opção desejada: """);

            Scanner teclado = new Scanner(System.in);

            while (!teclado.hasNextInt()) {
                System.out.println("Opção inválida. Deve ser digitado um número entre 1 e 4. Tente novamente: ");
                System.out.println("""
                    Escolha:
                    
                    1 - Consultar Saldos
                    2 - Depósito
                    3 - Saque
                    4 - Sair
                    
                    Digite a opção desejada:""");
                teclado = new Scanner(System.in);

                // "teclado" é a variável
            }

            opcao = teclado.nextInt();
            // "opção" variavel
            switch(opcao) {
                case 1:
                    System.out.println(cliente1.getExtrato());
                    break;
                case 2:
                    System.out.print("Digite a quantia a ser depositada: ");
                    Scanner valDeposito = new Scanner(System.in);
                    if (valDeposito.hasNextDouble()) {
                        double deposito = valDeposito.nextDouble();
                        cliente1.setDepositaValor(deposito);
                        break;
                    } else {
                        System.out.println("Valor digitado inválido. Repita.");
                        break;
                    }
                case 3:
                    System.out.println("Digite a quantia que queira sacar: ");
                    Scanner valSaque = new Scanner(System.in);
                    if (valSaque.hasNextDouble()) {
                        double saque = valSaque.nextDouble();
                        cliente1.setSaqueValor(saque);
                        break;
                    } else {
                        System.out.println("Valor digitado inválido. Repita.");
                        break;
                    }
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida. Deve ser digitado um número entre 1 e 4. Tente novamente: ");
                    break;
            }
        }
    }
}