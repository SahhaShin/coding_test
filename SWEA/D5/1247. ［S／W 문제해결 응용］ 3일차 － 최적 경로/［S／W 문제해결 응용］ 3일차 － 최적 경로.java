import java.util.Scanner;

public class Solution {
	static int[][] company=new int[1][2];
	static int[][] home = new int[1][2];
	static int[][] customer;
	static int N;
	static int result = Integer.MAX_VALUE;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt(); 
		
		for(int T=1;T<t+1;T++) {
			N= sc.nextInt();//고객 수
			
			//고객수로 배열 초기화 
			visit = new boolean[N];
			customer = new int[N][N];
			
			company[0][0]=sc.nextInt(); //회사 위치 x
			company[0][1]=sc.nextInt(); //회사 위치 y
			
			home[0][0]=sc.nextInt(); //집 위치 x
			home[0][1]=sc.nextInt(); //집 위치 y
			
			
			
			for(int i=0;i<N;i++) {
				customer[i][0]=sc.nextInt(); //고객 위치 x
				customer[i][1]=sc.nextInt(); //고객 위치 y
			}
			
			//출발지(이전좌표)를 집으로 시작 
			permutation(0, company[0][0], company[0][1], 0);
			
			//결과 도출 
			System.out.println("#"+T+" "+result);
			
			//초기화
			result = Integer.MAX_VALUE;
			
		}//TEST CASE END

	}
	
	static public void permutation(int depth, int prevX, int prevY, int distance) {
		
		if(depth==N) {
			//집까지 가는 거리 계산
			distance+=distance(prevX, prevY, home[0][0], home[0][1]);
			
			//거리가 가장 가까운 값으로 갱신 
			result=Math.min(result, distance);
		}
		
		
		for(int i=0;i<N;i++) {
			if(visit[i]) continue;
			
			visit[i]=true;
			permutation(depth+1, customer[i][0], customer[i][1], distance+distance(prevX, prevY, customer[i][0], customer[i][1]));
			visit[i]=false;
		}
	}
	
	static public int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}

}