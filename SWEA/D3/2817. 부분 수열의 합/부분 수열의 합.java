import java.util.Scanner;

public class Solution {

	/**
	 * 최소 1개 이상의 수를 선택하여 그 합이 K가 되는 경우의 수 
	 * => 부분 집합 문제 
	 * */
	
	static int[] nums;
	static int[] sel;
	static boolean[] visited;
	static int N, K, result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int T=1;T<=t;T++) {
			N = sc.nextInt();//수의 갯수
			K = sc.nextInt();//합
			
			//N만큼 수 입력 받기 
			nums = new int[N];
			sel = new int[N];
			visited = new boolean[N];
			for(int i=0;i<N;i++) {
				nums[i]=sc.nextInt();
			}
			
			powerset(0);
			
			System.out.println("#"+T+" "+result);
			
			//초기화
			result=0;
		}//TEST CASE END

	}
	
	static public void powerset(int depth) {
		//기저조건 
		
		if(depth==N) {
			int sum=0;
			for(int i=0;i<N;i++) {
				
				//선택 안된 요소들 빼고 합을 더해줘 
				if(sel[i]!=0) {
					//System.out.print(sel[i]+" ");//TEST 
					sum+=sel[i];
				}
			}
			//System.out.println("sum = "+sum);//TEST 
			if(sum==K) result++;
			return;
		}
		
		sel[depth]=nums[depth];
		powerset(depth+1);
		
		sel[depth]=0;
		powerset(depth+1);//depth3이 되었을 때 뭐 하나는 선택 안되어 있는 경우 
		
	}
}