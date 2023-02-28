import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. test case
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			int result=0;//RC카가 간 거리 
			int curr = 0;//현재 속도 
			//2. 몇개의 케이스를 입력할래
			
			int ex = sc.nextInt();
			for(int i=0;i<ex;i++) {
				
				int cmd = sc.nextInt(); //0 : 현재 속도 유지 / 1 : 가속 / 2 : 감속
				int speed = 0;
				if(cmd!=0) speed = sc.nextInt();
				
				if(cmd==0) {
					//유지
					result+=curr;
				}
				
				else if(cmd==1) {
					//가속
					curr +=speed;
					result+=curr;
				}
				
				else if(cmd==2) {
					//감속 
					curr-=speed;
					if(curr<0) curr=0;
					result+=curr;
				}
				
			}
			System.out.println("#"+T+" "+result);
		}//tc end
		
	}

}
