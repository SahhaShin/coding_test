import java.util.Scanner;

public class Solution {

	//N명의 사람이 붕어빵을 먹을 자격을 얻었다.
	//진기는 0초부터 붕어빵을 만들기 시작하며, M초의 시간을 들이면
	//K개의 붕어빵을 만들 수 있다.
	
	//0초 이후에 손님들이 언제 도착하는지 주어짐.
	//모든 손님들에게 기다리는 시간없이 붕어빵을 제공할 수 있는지 판별
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//1. TEST CASE
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			//2. n명의 사람 / 붕어빵이 나오는 초 간격 / 간격마다 k개의 붕어빵 제작
			int n = sc.nextInt();
			int time = sc.nextInt();
			int time_ea = sc.nextInt();
			
			//3. 손님이 언제 도착하는지 n명의 사람만큼 말해줌
			//시간대별로 카운팅 배열 (1개씩만 삼)
			int[] regist_time = new int[11112];//0이상 11,111이하
			for(int i=0;i<n;i++) {
				regist_time[sc.nextInt()]++;//손님이 오기로 한 시간에 인원 추가
			}
			
			//4. 1초1초 지날 때 마다 붕어빵을 만들면서
			//예약된 시간에 손님이 오면 판다.
			//근데 팔 게 없으면 Impossible
			//전체 시간 동안 끊킴 없이 팔면 Possible
			int bung=0;
			String result="Possible";//장사 초창기에는 모두 팔 수 있다는 으지!!!
			for(int i=0;i<11112;i++) {
				//0%2로 나눠도 0이기 때문에 0초부터 붕어빵이 만들어지는 것을 방지
				if(i!=0 && i%time==0)bung+=time_ea;
				
				//손님에게 붕어빵 팔기
				if(regist_time[i]>0) bung-=regist_time[i];
				
				//팔고난 다음에 붕어빵이 음수면 못판 사람이 있는 것
				if(bung<0) {
					result="Impossible";
					break;
				}
				
			}
			System.out.println("#"+T+" "+result);
		}//test case end		
	}
}