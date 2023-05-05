import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static Node[] lecture;
	static int count;
	static class Node{
		int start;
		int end;
		
		public Node(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		count = sc.nextInt();
		
		//초기화
		lecture = new Node[count];
		
		for(int i=0;i<count;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			lecture[i]=new Node(start,end);
		}
		
		//강의시작 시간 짧은순, 시작이 같다면 끝이 짧은 순
		Arrays.sort(lecture, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if(o1.start==o2.start) return o1.end>=o2.end?1:-1;
				else return o1.start>=o2.start?1:-1;
			}
		});

		//입력받기 끝
		
		System.out.println(lectureRoom());
	}
	public static int lectureRoom() {
		PriorityQueue<Integer> room = new PriorityQueue<>();
		
		Node first = lecture[0];
		room.add(first.end);
		
		//room에는 끝나는 시간이 가장 작은 순으로 배치되어 있다.
		//가장 작게 끝나는 시간에도 맞출 수 없으면 새롭게 방을 만드는 것이다.
		for(int i=1;i<count;i++) {
			if(room.peek()<=lecture[i].start) {
				room.poll();//기존 방의 끝나는 시간을 수정하기 위해 하나 빼고 수정하여 아래에서 넣는다.
			}
			room.add(lecture[i].end);//if에 걸리지 않았다면 새로운 방이다.
		}
		return room.size();
	}
}