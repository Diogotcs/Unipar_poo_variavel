/*
1. Faça um sistema que peça 3 valores some os 3 e mostre o total;
2. Faça um sistema que peça 2 valores e faça uma subtração.
3. Faça um sistema que peça 2 notas para o usuario some as duas e divida por 2;
4. Faça um sistema que peça 4 notas divida por 4;
5. Faça um sistema que o usuario vai informar 2 numeros e o sistema deve retornar a soma, subtração, divisão e multiplicação dos dois numeros.
6. Faça um sistema que pergunte para o usuario o nome, preço de produto, após isso pergunte qual o percentual de desconto, a saida precisa ser o nome do produto e o novo preço.
*/

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

            System.out.println("---------------");
            atividadeSeis(scanner);

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

        double primeiroValor = 0;
        double segundoValor = 0;

        System.out.println("Informe a primeira nota: ");
        primeiroValor = scanner.nextInt();

        System.out.println("Informe a segunda nota: ");
        segundoValor = scanner.nextInt();

        double total = primeiroValor + segundoValor;
        double media = total / 2;

        System.out.println("o media total e: " + media);

    }

    public static void atividadequatro(Scanner scanner) {
        System.out.println("Quarta Atividade");
        double primeiroValor = 0;
        double segundoValor = 0;
        double terceiroValor = 0;
        double quartoValor = 0;

        System.out.println("informe a primeira nota:");
        primeiroValor = scanner.nextInt();

        System.out.println("informe a segunda nota:");
        segundoValor = scanner.nextInt();

        System.out.println("informe a terceira nota:");
        terceiroValor = scanner.nextInt();

        System.out.println("informe a quarta nota:");
        quartoValor = scanner.nextInt();

        double total = primeiroValor + segundoValor + terceiroValor + quartoValor;
        double media = total / 4;

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

    public static void atividadeSeis(Scanner scanner) {
        System.out.print("Digite o nome do Usuario: ");
        String nomeUsuario = scanner.nextLine();

        System.out.print("Digite o preco do produto: R$ ");
        double precoProduto = scanner.nextDouble();

        System.out.print("Digite o percentual de desconto: ");
        int descontoPercentual = scanner.nextInt();

        double valorDesconto = precoProduto * descontoPercentual / 100;

        double novoPreco = precoProduto - valorDesconto;

        System.out.println("Usuario: " + nomeUsuario);
        System.out.println("Desconto: " + descontoPercentual + "%");
        System.out.println("Novo preco: R$ " + novoPreco);

    }
}