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
        System.out.printf("Sua agência é %s, conta %d e seu saldo R$ %.2f já está disponível para saque.\n",
                agencia, numero, saldo);

        // Fechar o scanner
        scanner.close();
    }
}
