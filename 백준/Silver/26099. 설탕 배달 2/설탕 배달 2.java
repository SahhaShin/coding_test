import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long kg = sc.nextLong();
		long count = 0;
		
		//5로 나눠지지 않을 때까지 3을 빼준다.
		while(kg%5!=0 && kg>0) {
			kg-=3;
			count++;
		}
		
		//5로 나눠진다고 판단되면 count + 5로 나눈 
		//5로 나눠진다고 판단안되면 -1
		if(kg%5==0) count += kg/5;
		else count = -1;
		
		System.out.println(count);

	}

}