import java.util.*;

public class GastosEmpresa {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] numeros = (sc.nextLine()).split(" ");
        int resu, maior = 0, indice = 0;

        for (int i=0; i<=numeros.length-1; i++){
            if(maior < Integer.parseInt(numeros[i])){
                maior = Integer.parseInt(numeros[i]);
                indice = i;}
        }
        resu = maior;
        maior = 0;

        for(int i=0; i<=numeros.length-1; i++){
            if(i != indice && Integer.parseInt(numeros[i]) > maior){
                maior = Integer.parseInt(numeros[i]);}
        }
        System.out.println(resu + maior);
    }
}
