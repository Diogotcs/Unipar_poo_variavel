//atividade 1
import java.util.Scanner;

class Atividade {
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
    }
}
