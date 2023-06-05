import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	public static class Number implements Comparable<Number>{
		int num;
		

		public Number(int num) {
			super();
			this.num = num;
		}


		@Override
		public int compareTo(Number o) {
			if(Math.abs(this.num)==Math.abs(o.num)) {
				return this.num>o.num?1:-1;
			}
			return Math.abs(this.num)>=Math.abs(o.num)?1:-1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//갯수
		
		PriorityQueue<Number> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			int num = sc.nextInt();
			if(num != 0) {
				pq.add(new Number(num));
				continue;
			}
			
			else {
				//0이면 가장 작은 절대값을 빼줘야함
				//가장 작은 절대값이 여러개이면 작은 수를 빼줘야 함 
				if(!pq.isEmpty())System.out.println(pq.poll().num);
				else System.out.println(0);
				
			}
		}

	}

}