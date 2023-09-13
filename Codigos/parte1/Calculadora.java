import java.util.Scanner;

public class Calculadora{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String simbolo = sc.nextLine();

        if(simbolo.equals("-")){
            float num1 = sc.nextFloat(), num2 = sc.nextFloat();
            System.out.println("RESULTADO: "+ (num1 - num2));
        } else if(simbolo.equals("+")){
            float num1 = sc.nextFloat(), num2 = sc.nextFloat();
            System.out.println("RESULTADO: "+ (num1 + num2));
        } else if (simbolo.equals("*")){
            float num1 = sc.nextFloat(), num2 = sc.nextFloat();
            System.out.println("RESULTADO: "+ (num1 * num2));
        } else if(simbolo.equals("/")){
            float num1 = sc.nextFloat(), num2 = sc.nextFloat();
            if (num1 == 0 | num2 == 0){
                System.out.println("ERRO");
            } else {
                System.out.println("RESULTADO: " + (num1 / num2));
            }
        } else{
            System.out.println("ENTRADA INVALIDA");
        }
    }
}


