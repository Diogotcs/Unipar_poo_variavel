
import java.util.Scanner;

class ExempleFor {

    public static void main(String[] args) {

        int numero = 0;
        int ateQuanto = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Informe um valor para multiplicar: ");
            numero = scanner.nextInt();

            System.out.println("Até quanto deseja multiplicar? ");
            ateQuanto = scanner.nextInt();
        }

        //i++ é igual a i = i + 1
        //for(variavel; condição; incremento){}
        for(int i = 0;i <= ateQuanto;i++){

            System.out.print( numero+ " x "+ i +" = " + i*numero);

            if (i*numero % 2 == 0){
                System.out.println(" -- É PAR");
            }
            else {
                System.out.println(" -- É IMPAR");
            }
        }

    }
}
