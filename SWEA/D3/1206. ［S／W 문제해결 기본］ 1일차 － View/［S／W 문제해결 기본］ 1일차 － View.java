import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for(int T=1;T<=10;T++) {
			
			int building_count = sc.nextInt();
			int[] building_height_list = new int[building_count];
			for(int i=0;i<building_count;i++) {
				building_height_list[i]=sc.nextInt();
			}
			
			//입력 끝
			
			int result = 0; //조망권 확보 수 
			
			for(int i=0;i<building_count;i++) {
				if(building_height_list[i]==0) continue;
				
				int min = Integer.MAX_VALUE;
				boolean go = true;//우측도 살필까? 
				
				//좌 높이 살피기
				for(int left=1;left<=2;left++) {
					if(building_height_list[i-left]<building_height_list[i]) {
						//현 빌딩보다 작다. -> 높이차 구하고, 가장 작은 높이면 교체 
						int diff = building_height_list[i] - building_height_list[i-left];
						min=Math.min(min, diff);
					}
					else {
						//현 빌딩보다 크다. -> 조망권 확보 실패 -> 우측도 확인할 필요 없음
						go = false;
						break;
					}
				}//left for
				
				//우 높이 살피기
				if(go) {
					for(int right=1;right<=2;right++) {
						if(building_height_list[i+right]<building_height_list[i]) {
							//현 빌딩보다 작다. -> 높이차 구하고, 가장 작은 높이면 교체 
							int diff = building_height_list[i] - building_height_list[i+right];
							min=Math.min(min, diff);
						}
						else {
							//현 빌딩보다 크다. -> 조망권 확보 실패 -> 우측도 확인할 필요 없음
							go = false;
							break;
						}
					}//right for
				}//right if
				
				if(go) result += min;//좌우를 모두 살폈을 때 한 빌딩(테스트케이스)에서 조망권은 몇 세대?
				
			}//i for
			
			//결과 도출
			System.out.println("#"+T+" "+result);
			
			
		}
	}
}