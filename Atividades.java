import java.util.Scanner;

class EntradaProcessamentoSaida {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Atividades");
            atividadeUm(scanner);

            System.out.println("---------------");
             atividadeDois(scanner);

            System.out.println("---------------");
             atividadeTres(scanner);

            System.out.println("---------------");
             atividadequatro(scanner);

            System.out.println("---------------");
             atividadeCinco(scanner);

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public static void atividadeUm(Scanner scanner) {
        System.out.println("Primeira Atividade");
        int primeiroValor = 0;
        int segundoValor = 0;
        int terceiroValor = 0;

        System.out.println("Informe o primeiro valor: ");
        primeiroValor = scanner.nextInt();

        System.out.println("Informe o segundo valor: ");
        segundoValor = scanner.nextInt();

        System.out.println("Informe o terceiro valor: ");
        terceiroValor = scanner.nextInt();

        int total = primeiroValor + segundoValor + terceiroValor;

        System.out.println("o total e: " + total);

    }

    public static void atividadeDois(Scanner scanner) {
        System.out.println("Segunda Atividade");
        int primeiroValor = 0;
        int segundoValor = 0;

        System.out.println("Informe o primeiro valor: ");
        primeiroValor = scanner.nextInt();

        System.out.println("Informe o segundo valor: ");
        segundoValor = scanner.nextInt();

        int total = primeiroValor - segundoValor;

        System.out.println("o total e: " + total);
    }

    public static void atividadeTres(Scanner scanner) {

        int primeiroValor = 0;
        int segundoValor = 0;

        System.out.println("Informe a primeira nota: ");
        primeiroValor = scanner.nextInt();

        System.out.println("Informe a segunda nota: ");
        segundoValor = scanner.nextInt();

        int total = primeiroValor + segundoValor;
        int media = total / 2;

        System.out.println("o media total e: " + media);

    }

    public static void atividadequatro(Scanner scanner) {
        System.out.println("Quarta Atividade");
        int primeiroValor = 0;
        int segundoValor = 0;
        int terceiroValor = 0;
        int quartoValor = 0;

        System.out.println("informe a primeira nota:");
        primeiroValor = scanner.nextInt();

        System.out.println("informe a segunda nota:");
        segundoValor = scanner.nextInt();

        System.out.println("informe a terceira nota:");
        terceiroValor = scanner.nextInt();

        System.out.println("informe a quarta nota:");
        quartoValor = scanner.nextInt();

        int total = primeiroValor + segundoValor + terceiroValor + quartoValor;
        int media = total / 4;

        System.out.println("a media é " + media);
    }

    public static void atividadeCinco(Scanner scanner) {

        double primeiroValor = 0;
        double segundoValor = 0;

        System.out.println("Informe a primeira nota: ");
        primeiroValor = scanner.nextInt();

        System.out.println("Informe a segunda nota: ");
        segundoValor = scanner.nextInt();

        double soma = primeiroValor + segundoValor;
        double subtracao = primeiroValor - segundoValor;
        double divisao = primeiroValor / segundoValor;
        double multiplicacao = primeiroValor * segundoValor;

        System.out.println("a soma total e: " + soma);
        System.out.println("a subtracao total e: " + subtracao);
        System.out.println("a divisao total e: " + divisao);
        System.out.println("a multiplicacao total e: " + multiplicacao);
    }
}