import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=num;i++) {
			q.add(i);
		}
		
		//연산 시작
		while(q.size()!=1) {
			//맨 위를 버린다.
			q.poll();
			
			//첫번째있는 요소를 맨 뒤로 보낸다.
			int first = q.poll();
			q.add(first);
		}
		
		System.out.println(q.poll());

	}

}