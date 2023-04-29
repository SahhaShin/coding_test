import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class People implements Comparable<People>{
		int age;
		int order;
		String name;
		public People(int age, int order, String name) {
			super();
			this.age = age;
			this.order = order;
			this.name = name;
		}
		@Override
		public int compareTo(People o) {
			if(this.age==o.age) {
				return this.order>o.order?1:-1;
			}
			return this.age>o.age?1:-1;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		PriorityQueue<People> list = new PriorityQueue<>();
		
		for(int i=0;i<count;i++) {
			int age = sc.nextInt();
			String name = sc.next();
			list.add(new People(age,i,name));
		}

		for(int i=0;i<count;i++) {
			People cur = list.poll();
			System.out.println(cur.age+" "+cur.name);
		}
	}

}