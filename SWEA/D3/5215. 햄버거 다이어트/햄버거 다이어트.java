import java.util.Scanner;

public class Solution {
	/**
	 * 주어진 제한 칼로리 이하의 조합중에서 가장 맛에 대한 점수가 높은 햄버거의 점수를 출력
	 * 재료 갯수는 정해지지 않음 
	 * 순서는 중요하지 않음 -> 재료1 재료2, 재료2 재료1은 서로 같은 것임 
	 * => 부분집합 
	 * */
	static int[][] ingredient;//재료의 점수 칼로리 
	static int N,L;
	static int maxScore = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int T=1;T<=t;T++){
			N = sc.nextInt();//재료의 수 
			L = sc.nextInt();//제한 칼로리 
			
			//재료의 점수 칼로리 
			ingredient = new int[N][N];
			for(int i=0;i<N;i++) {
				ingredient[i][0]=sc.nextInt();
				ingredient[i][1]=sc.nextInt();
			}
			
			powerset(0,0,0);
			
			System.out.println("#"+T+" "+maxScore);
			
			//초기화
			maxScore = Integer.MIN_VALUE;
		}//test case end
	}
	
	/**
	 * 제한 칼로리 이하의 칼로리이면 높은 점수를 갱신할 것 
	 * 제한 칼로리를 넘으면 멈출 것
	 * 재료 수를 모두 고려했으면 멈출 것
	 * depth의 재료를 선택했을 때와 선택안했을 때를 고려할 것 == powerset 부분집합 
	 * */
	static public void powerset(int depth, int calory, int score) {
		if(calory<=L)maxScore=Math.max(maxScore, score);
		if(calory>L) return;
		if(depth==N) return;
		
		powerset(depth+1,calory+ingredient[depth][1],score+ingredient[depth][0]); //해당 재료를 포함하는 경우 
		powerset(depth+1,calory,score);// 해당 재료를 포함하지 않는 경우 	
	}
}