import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	//최대 힙
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. 테스트 케이스
		int t = sc.nextInt();//2
		
		for(int T=1;T<t+1;T++) {
			System.out.print("#"+T+" ");
			PriorityQueue pq = new PriorityQueue(Collections.reverseOrder());
			
			//2. 몇 개의 케이스를 입력할건지
			int count=sc.nextInt();//3
			
			for(int i=0;i<count;i++) {
				int mode = sc.nextInt();
				if(mode==1) {
					int num = sc.nextInt();//입력한 숫자 추가
					pq.offer(num);
					
				}
				else if(mode==2) {
					//가장 위에 있는 값 출력
					if(pq.isEmpty()) System.out.print("-1 ");
					else System.out.print(pq.poll()+" ");
				}
			}
			System.out.println();

		}
	}

}
