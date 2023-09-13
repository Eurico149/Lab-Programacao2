import java.util.Scanner;

public class Adivinhacao {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt(), adivinhacao;

        do{
            adivinhacao = sc.nextInt();
            if(adivinhacao > numero){
                System.out.println("MAIOR");
            } else if(adivinhacao < numero){
                System.out.println("MENOR");
            } else{
                System.out.println("ACERTOU");
            }
        } while(numero != adivinhacao);
    }
}
