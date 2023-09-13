import java.util.Scanner;

public class CadeWally{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String nome = "";
		while(true){
			nome = sc.nextLine();
			String saida = "?";
			for(String palavra : nome.split(" ")){
				if(palavra.length() == 5){
					saida = palavra;
				}
			}
			if(nome.equals("wally")){
				break;
			}
			System.out.println(saida);
		}
	}
}
