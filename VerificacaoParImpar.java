
import java.util.Scanner;

class VerificacaoParImpar {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
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
} 