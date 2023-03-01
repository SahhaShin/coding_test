import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		//1. test case
		for(int T=1;T<t+1;T++) {
			int city=sc.nextInt();//도시수
			int dis = sc.nextInt();//제한거리
			int[] map = new int[city+2]; //0과 N+1은 1이 있다고 친다.
			map[0]=1;
			map[city+1]=1;
			
			for(int i=1;i<=city;i++) {
				map[i]= sc.nextInt();//지도정보 
			}
			
			//2. 필요한 차원 관문갯수
			int zero=0;
			int result=0;
			for(int i=0;i<city+1;i++) {
				//0을 세주다가 1을 만나면 다시 시작 
				if(map[i]==1) {
					zero=0;
				}
				else if(map[i]==0) {
					zero++;
					//zero가 최대 거리까지 쌓였는데도 1이 없으면 관문 하나를 생성해줘야한다.
					if(zero==dis && map[i]!=1) {
						result++;
						zero=0;//만들어준 관문에서 새롭게 시작 
					}
				}
			}
		
			
			System.out.println("#"+T+" "+result);
		}//test case end

	}

}
