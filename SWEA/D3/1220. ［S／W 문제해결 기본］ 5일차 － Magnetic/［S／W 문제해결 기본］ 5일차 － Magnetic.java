import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int T=1;T<11;T++) {
			//1. 정사각형 한 변의 길이 
			int N = sc.nextInt();
			
			//2. 100x100 테이블 초기 모습
			//1 )-> N극(빨강) (N극 테이블은 위)
			//2 )- > S극(파랑) (S극 테이블은 아래) 
			int[][] map = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			//3. 구현 
			//S극 자석 전 단계에 N극이 있었다면 교착상태가 된다.
			//세로로 순차적으로 접근한다.
			//0이 있기 때문에 꼭 1,2일 때 정확히 제시해줘야한다.
			int count=0;
			for(int i=0;i<N;i++) {
				int prev=0; //이전 자석 정보를 가짐 
				for(int j=0;j<N;j++) {
					if(map[j][i]==1) {
						prev=1;//이전단계 자석 저장 
					}
					if(map[j][i]==2) {//S극발견 
						if(prev==1) {//이전단계 N극을 발견했더라면 
							count++;//교착상태 추가 
						}
						prev=2;
					}
				}
			
			}
			
			//4.결과 : 1개 -> 교착상태갯수 
			System.out.println("#"+T+" "+count);
			
		}

	}

}
