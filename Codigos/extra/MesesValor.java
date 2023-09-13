import java.util.*;

public class MesesValor{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] meses = (sc.nextLine()).split(" "), valores = (sc.nextLine()).split(" ");
        String mes = sc.nextLine();

        for (int i=0; i <= meses.length; i++){
            if (meses[i].equals(mes)){
                System.out.println(valores[i]);
                break;
            }
        }

    }
}
