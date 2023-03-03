import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. 테스트케이스
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			//2. 현재시각, 약속시각 
			String[] now = sc.next().split(":");
			String[] next = sc.next().split(":");
			
			//3. int로 변경 
			int[] now_i = new int[3];
			int[] next_i = new int[3];
			
			for(int i=0;i<3;i++) {
				now_i[i]=Integer.parseInt(now[i]);
				next_i[i]=Integer.parseInt(next[i]);
			}
			
			//4. 약속시간 - 현재시간 = 남은 시간
			int[] rt = new int[3]; 
			for(int i=2;i>=0;i--) {
				//분 초 계산일 경우 음수이면 +60 -> 분-- , 시간 --
				if(i!=0) {
					if(next_i[i]-now_i[i]<0) {
						next_i[i-1]--;
						rt[i]+=next_i[i]+60-now_i[i];
					}
					else {
						rt[i]+=next_i[i]-now_i[i];
					}
				}
				
				//시간 계산일 경우 음수이면 +24
				else {
					if(next_i[i]-now_i[i]<0) {
						rt[i]+=next_i[i]+24-now_i[i];
					}
					else {
						rt[i]+=next_i[i]-now_i[i];
					}
				}
			}
			
			//결과 정리
			
			
			System.out.printf("#%d %02d%s%02d%s%02d\n",T,rt[0],":",rt[1],":",rt[2]);
			
		}//test case end

	}

}
