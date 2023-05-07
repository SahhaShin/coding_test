import java.util.Scanner;

public class Main {
	static char[][] chess;
	static int n,m;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		chess = new char[n][m];
		for(int i=0;i<n;i++) {
			chess[i]=sc.next().toCharArray();
		}
		

		//8x8 선정
		//한 줄씩 밑으로 내려가기 -> 한 칸씩 옆으로 가기
		for(int startR=0;startR<=n-8;startR++) {
			for(int startC=0; startC<=m-8;startC++) {
				coloring(startR,startC);
			}
		}
		
		System.out.println(min);
		
	}
	
	//체스판 자체는 안건들이고 값만 비교하는 식으로 할 것임
	public static void coloring(int startR, int startC) {
		int result=0;

		//0 0이 흰색인 경우랑 검정색인 경우 2가지
		//흰색인 경우 짝수 줄은 짝수가 흰색 짝수줄은 짝수가 흰색
		//검정색인 경우 짝수 줄은 짝수가 점정색 짝수줄은 짝수가 검정색
		for(int d=0;d<2;d++) {
			char start = 'W';
			
			if(d==0) {
				start = 'W';
				if(chess[startR][startC]=='B') result++;
			}
			
			if(d==1) {
				start = 'B';
				if(chess[startR][startC]=='W') result++;
			}
			
			//WB 교차 판단
			for(int i=startR;i<startR+8;i++) {
				for(int j=startC; j<startC+8;j++) {
					if(i==startR && j==startC) continue;
					
					if((i-startR)%2==0 && (j-startC)%2==0 && chess[i][j]!=start) result++;
					else if((i-startR)%2==0 && (j-startC)%2==1 && chess[i][j]==start)result++;
					
					else if((i-startR)%2==1 && (j-startC)%2==0 && chess[i][j]==start)result++;
					else if((i-startR)%2==1 && (j-startC)%2==1 && chess[i][j]!=start) result++;	
				}
			}//교차 판단 끝
			min = Math.min(min, result);
			result=0;//초기화
		}
	}
}