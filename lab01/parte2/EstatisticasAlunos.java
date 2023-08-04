import java.util.*;

public class EstatisticasAlunos{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String aluno = sc.nextLine();
        String lista = "";
        while(!aluno.equals("-")) {
            String[] aux = aluno.split(" ");
            if (lista.isEmpty()){
                lista = aux[1];
            } else{
                lista = lista + " " + aux[1];}
            aluno = sc.nextLine();
        }
        String[] notas = lista.split(" ");
        int acima = 0, abaixo = 0, media = 0, maior = 0, menor = 1000;
        for(int i=0; i<(notas.length); i++){
            if(Integer.parseInt(notas[i]) >= 700){
                acima = acima + 1;
            } else{
                abaixo = abaixo + 1;
            }
            media = media + Integer.parseInt(notas[i]);
            if(maior < Integer.parseInt(notas[i])){
                maior = Integer.parseInt(notas[i]);
            }
            if(menor > Integer.parseInt(notas[i])){
                menor = Integer.parseInt(notas[i]);
            }
        }
        System.out.println("maior: "+ maior);
        System.out.println("menor: "+ menor);
        System.out.println("media: "+ (media / notas.length));
        System.out.println("acima: "+ acima);
        System.out.println("abaixo: "+ abaixo);
    }
}
