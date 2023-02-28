import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num=sc.nextInt();
		
		int floor=1;
		int times=1;
		while(floor<num) {
			floor+=6*times;
			times++;
		}
		
		System.out.println(times);

	}

}
