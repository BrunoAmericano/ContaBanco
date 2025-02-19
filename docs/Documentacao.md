# Documentação do Projeto ContaBanco

## 1. Descrição do Projeto
O projeto **ContaBanco** tem como objetivo praticar os conceitos básicos da linguagem Java, incluindo entrada de dados, tratamento de erros, formatação de saída e manipulação de variáveis. O sistema solicita informações bancárias do usuário via terminal e exibe uma mensagem formatada com os dados fornecidos.

## 2. Tecnologias Utilizadas
- Java (JDK 8 ou superior)
- IDE (VS Code, Eclipse, IntelliJ, ou outra de preferência)
- Git/GitHub para versionamento de código

## 3. Funcionalidades do Sistema
- Captura de dados do usuário via terminal
- Validação de entradas para evitar erros
- Exibição de mensagem formatada com os dados informados

## 4. Estrutura do Projeto
O projeto possui uma estrutura simples com apenas um arquivo principal:
```
ContaBanco/
  ├── src/
  │   ├── ContaTerminal.java
```

## 5. Implementação do Código

### 5.1 Primeira Versão do Código (Sem Melhorias)
```java
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, digite o número da Conta:");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Por favor, digite o número da Agência:");
        String agencia = scanner.nextLine();

        System.out.println("Por favor, digite seu nome:");
        String nomeCliente = scanner.nextLine();

        System.out.println("Por favor, digite o saldo inicial:");
        double saldo = scanner.nextDouble();

        System.out.println("\nOlá " + nomeCliente + ", obrigado por criar uma conta em nosso banco.");
        System.out.println("Sua agência é " + agencia + ", conta " + numero + " e seu saldo R$ " + saldo + " já está disponível para saque.");

        scanner.close();
    }
}
```

### 5.2 Código Melhorado com Validação de Entrada
```java
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        // Configurar Scanner e Locale para ponto decimal
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        int numero = 0;
        String agencia = "";
        String nomeCliente = "";
        double saldo = 0.0;

        // Solicitar o número da conta e validar entrada
        while (true) {
            try {
                System.out.println("Por favor, digite o número da Conta:");
                numero = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha
                if (numero > 0) break;
                System.out.println("Erro: O número da conta deve ser positivo.");
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um número inteiro válido.");
                scanner.nextLine(); // Limpar entrada inválida
            }
        }

        // Solicitar a agência
        while (true) {
            System.out.println("Por favor, digite o número da Agência:");
            agencia = scanner.nextLine().trim();
            if (!agencia.isEmpty()) break;
            System.out.println("Erro: A agência não pode estar vazia.");
        }

        // Solicitar o nome do cliente
        while (true) {
            System.out.println("Por favor, digite seu nome:");
            nomeCliente = scanner.nextLine().trim();
            if (!nomeCliente.isEmpty() && nomeCliente.matches("^[a-zA-ZÀ-ÿ\\s]+$")) break;
            System.out.println("Erro: O nome deve conter apenas letras e espaços.");
        }

        // Solicitar o saldo inicial e validar entrada
        while (true) {
            try {
                System.out.println("Por favor, digite o saldo inicial:");
                saldo = scanner.nextDouble();
                if (saldo >= 0) break;
                System.out.println("Erro: O saldo não pode ser negativo.");
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um valor decimal válido (ex: 100.50).");
                scanner.nextLine(); // Limpar entrada inválida
            }
        }

        // Exibir a mensagem formatada com duas casas decimais
        System.out.println("\nOlá " + nomeCliente + ", obrigado por criar uma conta em nosso banco.");
        System.out.printf("Sua agência é %s, conta %d e seu saldo R$ %.2f já está disponível para saque.\n", agencia, numero, saldo);

        // Fechar o scanner
        scanner.close();
    }
}
```

## 6. Melhorias Implementadas
✅ **Validação do número da conta** → Apenas números inteiros positivos são aceitos.
✅ **Validação da agência** → Campo não pode ser vazio.
✅ **Validação do nome do cliente** → Aceita apenas letras e espaços, impedindo caracteres inválidos.
✅ **Validação do saldo inicial** → Apenas valores positivos são aceitos.
✅ **Tratamento de erros** → Programa continua solicitando entrada caso o usuário insira um valor inválido.
✅ **Formatação do saldo** → Agora o saldo é exibido com duas casas decimais (`%.2f`).

