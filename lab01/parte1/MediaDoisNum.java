import java.util.Scanner;

public class MediaDoisNum{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double num1 = sc.nextFloat(), num2 = sc.nextFloat();
		double media = (num1 + num2) / 2;

		if(media >= 7.0){
			System.out.println("pass: True!");
		} else{
			System.out.println("pass: False!");
		}
	}
}
