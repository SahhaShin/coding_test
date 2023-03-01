import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. test case
		int t = sc.nextInt();
		for(int T=1;T<t+1;T++) {
			//2. 퍼즐 크기 N
			int N = sc.nextInt();
			
			//3. 단어 길이
			int len = sc.nextInt();
			
			//4. 퍼즐 정보
			int[][] p = new int[N][N];
			for(int i=0;i<p.length;i++) {
				for(int j=0;j<p.length;j++) {
					p[i][j]=sc.nextInt();
				}
			}
			
			//5. 단어 길이가 들어갈 수 있는 공간은 몇 개인가 
			//가로 탐색
			int result=0;
			for(int i=0;i<N;i++) {
				int count=0;//1의 길이를 세줄 것 
				for(int j=0;j<N;j++) {
					if(p[i][j]==1) {
						//1을 만나면 자리 ++
						count++;
						//단어길이와 같아지면 result++
						if(count==len) result++;
						if(count>len) {
							//단어 길이보다 커지면 이전 result값을 지워준다.
							//다시 초기화 
							result--;
							count=0;
						}
					}
					else {
						//0을 만나면 초기화 
						count=0;
					}
				}
			}
			
			//세로 탐색 
			
			for(int i=0;i<N;i++) {
				int count=0;//1의 길이를 세줄 것 
				for(int j=0;j<N;j++) {
					if(p[j][i]==1) {
						//1을 만나면 자리 ++
						count++;
						//단어길이와 같아지면 result++
						if(count==len) result++;
						if(count>len) {
							//단어 길이보다 커지면 이전 result값을 지워준다.
							//다시 초기화 
							result--;
							count=0;
						}
					}
					else {
						//0을 만나면 초기화 
						count=0;
					}
				}
			}
			System.out.println("#"+T+" "+result);
		}//test case end

	}

}
