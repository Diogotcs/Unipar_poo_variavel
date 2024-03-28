atividade 1
import java.util.Scanner;

class HelloWorld {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int idade = 18;

            System.out.println("Informe sua idade");
            idade = sc.nextInt();

            if( idade >=18){
                System.out.println("Voce é maior de idade");
            }else{
                System.out.println("Voce é menor de idade");
            }
        }


atividade 2
    
import java.util.Scanner;

class HelloWorld {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int Num = 0;

        System.out.println("Informe um numero");
        Num = sc.nextInt();

        if( Num % 2 == 0){
            System.out.println("Numero informado e par");
        }else{
            System.out.println("Numero informado e impar");
        }

    }
} 
atividade 3
import java.util.Scanner;

 class Verification {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String nomeUsuario = "Andrey";
        String senha = "senha123";

        System.out.println("Nome do usuario: ");
        nomeUsuario= scanner.nextLine();

        System.out.println("Senha: ");
        senha= scanner.nextLine();

        if( nomeUsuario == "Andrey" && senha == "senha123") {
            System.out.println("Login bem sucedido");
        }else{
            System.out.println("Nome de usuario ou senha incorretos");
        }

    }
}

atividade 4        
import java.util.Scanner;

 class Verification {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numero1 = 0;
        int numero2 = 0;

        System.out.println("Informe um número: ");
        numero1= scanner.nextInt();

        System.out.println("Informe outro número: ");
        numero2= scanner.nextInt();

        if( numero1 > numero2 ){
            System.out.println("O maior número é: "+ numero1);
        } else if (numero2 > numero1) {
            System.out.println("O maior número é: "+ numero2);
        }else  {
            System.out.println("Os números são iguais.");
        }

    }
}
    
