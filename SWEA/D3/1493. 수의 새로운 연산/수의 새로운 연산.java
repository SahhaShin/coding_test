import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. 테스트케이스 
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			//2. 입력값 받기 &a &b
			int a = sc.nextInt();
			int b = sc.nextInt();

			int[][] xy = new int[2][2];
			int curr_num=1;
			xy: for(int i=1;i<=30000+1;i++) {
				//i는 최대값을 구함
				for(int r=1,c=i;r<=i && c>=1;r++,c--) {
					if(curr_num==a) {
						xy[0][0]=r;
						xy[0][1]=c;
					}
					if(curr_num==b) {
						xy[1][0]=r;
						xy[1][1]=c;
					}
					curr_num++;
				}
					
				//a b의 xy가 모두 채워졌으면 stop
				if(xy[0][0]!=0 && xy[0][1]!=0 && xy[1][0] != 0 && xy[1][1]!= 0) {
					break xy;
				}
			}
			
			//5. 두 지점을 더해준다.
			int new_x = xy[0][0]+xy[1][0];
			int new_y = xy[0][1]+xy[1][1];
			
			//6. 새로운 지점의 값을 알아낸다.
			//새로운 지점이 몇번째 대각선인가?
			//(1,3) -> 3번줄 / (2,3) -> 4번줄 / (3,3) -> 5번줄
			//즉, 대각선은 c+(r-1)
			int result=0;
			int curr_num2=1;
			xy: for(int i=1;i<=new_y+(new_x-1);i++)  {
				//i는 최대값을 구함
				for(int r=1,c=i;r<=i && c>=1;r++,c--) {
					if(r==new_x && c==new_y) {
						result=curr_num2;
						break xy;
					}
					curr_num2++;
						
				}
			}
			
			System.out.println("#"+T+" "+result);
			
		}//test case end
		

	}

}
