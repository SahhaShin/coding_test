import java.util.Scanner;

public class Main {
	static int[] sel;
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//전체 수
		M = sc.nextInt();//조합수
		
		//초기화
		sel = new int[M];
		
		Combination(0);
		System.out.println(sb);
		
	}
	
	public static void Combination(int count) {
		if(count==M) {
			for(int i=0;i<M;i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			sel[count]=i;
			
			Combination(count+1);//이거 선택		
		}
	}
}