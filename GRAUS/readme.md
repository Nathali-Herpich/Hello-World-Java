# 🌟 Projetos básicos em Java: Explicação do 𝙿𝚛𝚘𝚓𝚎𝚝𝚘 𝙶𝚁𝙰𝚄𝚂 

✅ CÓDIGO:
   `import java.util.Scanner;`
   
🔹 Importa a classe Scanner da biblioteca Java.
Ela permite ler entradas do usuário pelo teclado.
#

    public class Main {}

🔹 Define a classe principal chamada Main.
Todo programa Java começa com uma classe pública que contém o método main.
#

    public static void main(String[] args) {}
🔹 Define o método principal onde o programa inicia sua execução.
#

``` Java
      Scanner scanner = new Scanner(System.in);
  ```

🔹 Cria um objeto scanner para ler dados da entrada padrão (teclado).
Esse objeto permite capturar valores digitados pelo usuário.
#
        System.out.print("Digite a temperatura em Celsius: ");

  
  
🔹 Exibe no console uma mensagem pedindo para o usuário digitar a temperatura em Celsius.
(O uso de print evita a quebra de linha, mantendo o cursor na mesma linha da mensagem.)
#
```
   double celsius = scanner.nextDouble();
```
🔹 Lê o valor digitado pelo usuário (espera um número com ponto ou vírgula decimal) e armazena na variável celsius do tipo double.
#

        scanner.close();
        
🔹 Fecha o scanner.

#

Boa prática para liberar o recurso da entrada padrão (System.in) que foi usado.


        double fahrenheit = (celsius * 9/5) + 32;
        
🔹 Realiza a conversão da temperatura usando a fórmula:


Fahrenheit
=
(
Celsius
×
9
/
5
)
+
32
Fahrenheit = (Celsius × 
59
​
 )+32.
 
O resultado é armazenado na variável fahrenheit.

       `` System.out.println(celsius + " graus Celsius é igual a " + fahrenheit + " graus Fahrenheit.");``
       
🔹 Exibe o resultado da conversão no console, informando os dois valores com texto explicativo.

  `` }
     }``
     

🔹 Fecha o método main e a classe Main.

✅ RESUMO:

Este programa:

- Lê uma temperatura em graus Celsius digitada pelo usuário.

- Converte para graus Fahrenheit com a fórmula padrão.

- Exibe o resultado no console.

- Utiliza Scanner para entrada e `System.out.println` para saída.
