import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] garbage = new int[43];//카운팅 
		int count=0;//서로 다른 나머지 갯수 
		for(int i=0;i<10;i++) {
			int num=sc.nextInt();
			if(garbage[num%42]==0) {
				garbage[num%42]++;
				count++;
			}
		}
		
		System.out.println(count);
	}
}