import java.util.Scanner;

public class Main {
	static int[] sel;
	static int N,M;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//전체 수
		M = sc.nextInt();//조합수
		
		//초기화
		sel = new int[M];
		
		Combination(1,0);
		
	}
	
	public static void Combination(int depth, int count) {
		if(count==M) {
			for(int i=0;i<M;i++) {
				System.out.printf(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		
		if(depth==N+1) return;
		
		
		sel[count]=depth;

		Combination(depth+1, count+1);//이거 선택
		
		Combination(depth+1, count);//이거 선택 안함
	}
}