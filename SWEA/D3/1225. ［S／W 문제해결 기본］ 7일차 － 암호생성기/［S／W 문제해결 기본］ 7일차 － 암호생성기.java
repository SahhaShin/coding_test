import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for(int T=1;T<11;T++) {
			//1. test case
			int test = sc.nextInt();
			
			//2. 8개의 데이터
			Queue<Integer> q = new LinkedList<>();
			for(int i=0;i<8;i++) {
				q.offer(sc.nextInt());
			}
			//3. 앞자리 하나씩 빼고 뒤로 보내기
			int minus=0;
			
			while(true) {
				minus=(minus)%5+1;
				int op=q.poll()-minus;//빼고
				if(op<0) op=0; //마이너스 관리
				q.offer(op);//넣기
				
				if(op==0) break;
			}
		
			
			System.out.print("#"+T+" ");
			for(int i=0;i<8;i++) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}
	}
}