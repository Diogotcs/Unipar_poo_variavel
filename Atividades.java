import java.util.Scanner;

class EntradaProcessamentoSaida {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Atividades");
            atividadeUm(scanner);
            System.out.println("---------------");
            atividadequatro(scanner);

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

}