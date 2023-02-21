import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 좌석수 N
		int N = sc.nextInt();
		
		//공 최대 받을 수 있는 횟수 M
		int M = sc.nextInt();
		
		//시계 / 반시계 방향
		int L = sc.nextInt();
		
		//카운팅 배열 
		int[] count = new int[N];
		
		//공을 몇번 던지는가 기록 
		int result=0;
		
		//1번에서 시작 (index 0)
		int index=0;
		count[index]++;
		
		while(true) {
			//공을 받은 횟수가 짝수면 반시계 L 
			//공을 받은 횟수가 홀수면 시계 L
			if(count[index]==M) {
				break;
			}
			
			if(count[index]%2==0) {
				index-=L;
				if(index<0) {
					index=N+index;
				}
			}
			//홀수면 시계 L
			else {
				index+=L;
				if(index>=N) {
					index=index-N;
				}
			}
			
			count[index]++;
			result++;
			
		}//while end
		
		System.out.println(result);
	}

}
