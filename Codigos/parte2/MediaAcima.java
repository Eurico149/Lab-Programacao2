import java.util.Scanner;

public class MediaAcima{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();

		float media = 0;
		int cont = 0;
		for(String  num : entrada.split(" ")){
			media = media + Integer.parseInt(num);
			cont = cont + 1;}
		media = media / cont;

		String saida = "";
		for(String num : entrada.split(" ")){
			if(Integer.parseInt(num) > media){
				saida = saida +" "+ num;}}
		System.out.println(saida);
	}
}

