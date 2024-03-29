import java.util.Scanner;

class EntradaProcessamentoSaida {
    public static void main(String[] args) {
        System.out.println("fora do metodo");
        atividadeUm();
    }

    public static void atividadeUm() {
        System.out.println("dentro do metodo");
        int primeiroValor = 0;
        int segundoValor = 0;
        int terceiroValor = 0;
        int quartoValor = 0;

        try (Scanner scanner = new Scanner(System.in)) {
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
}