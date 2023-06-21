import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int t = sc.nextInt();
		
		
		for(int T=1;T<=t;T++) {
			int floor = sc.nextInt();//층 == k
			int N = sc.nextInt();//호 == n
			
			int result = setAPT(floor, N);
			
			System.out.println(result);
		}
	}
	
	public static int setAPT(int floor, int N) {
		
		//호수가 0이면 0
		if(N == 0) return 0;
		else if(floor==0) return N;
		else return setAPT(floor, N-1) + setAPT(floor-1, N);
		
	}

}