import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static Deque<Integer> dq = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		
		
		for(int i=0;i<count;i++) {
			String menu = sc.next();
			
			if(menu.equals("push_front")) {
				int num = sc.nextInt();
				push_front(num);
			}
			
			else if(menu.equals("push_back")) {
				int num = sc.nextInt();
				push_back(num);
			}
			
			else if(menu.equals("pop_front"))pop_front();
			else if(menu.equals("pop_back"))pop_back();
			else if(menu.equals("size"))size();
			else if(menu.equals("empty"))empty();
			else if(menu.equals("front"))front();
			else if(menu.equals("back"))back();
		}
		
		System.out.println(sb);

	}
	
//	push_front X: 정수 X를 덱의 앞에 넣는다.
	public static void push_front(int x) {
		dq.addFirst(x);
	}
	
//	push_back X: 정수 X를 덱의 뒤에 넣는다.
	public static void push_back(int x) {
		dq.addLast(x);
	}
	
	
//	pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public static void pop_front() {
		if(dq.isEmpty())sb.append("-1").append("\n");
		else sb.append(dq.pollFirst()).append("\n");
	}
	
//	pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public static void pop_back() {
		if(dq.isEmpty())sb.append("-1").append("\n");
		else sb.append(dq.pollLast()).append("\n");
	}
	
//	size: 덱에 들어있는 정수의 개수를 출력한다.
	public static void size() {
		sb.append(dq.size()).append("\n");
	}
	
//	empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
	public static void empty() {
		if(dq.isEmpty())sb.append("1").append("\n");
		else sb.append("0").append("\n");
	}
	
//	front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public static void front() {
		if(dq.isEmpty())sb.append("-1").append("\n");
		else sb.append(dq.getFirst()).append("\n");
	}
	
//	back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public static void back() {
		if(dq.isEmpty())sb.append("-1").append("\n");
		else sb.append(dq.getLast()).append("\n");
	}
}