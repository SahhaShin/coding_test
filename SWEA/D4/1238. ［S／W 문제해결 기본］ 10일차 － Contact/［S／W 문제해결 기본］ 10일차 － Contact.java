import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static List<Node>[] contactList;
	static int LastContactNum;// 마지막으로 연락한 사람의 번호
	static int LastContactOrder;// 마지막으로 연락한 사람의 순서

	static class Node {
		int num;
		int order;// 전달받은 순서

		public Node(int num, int order) {
			super();
			this.num = num;
			this.order = order;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int T = 1; T <= 10; T++) {
			int dataLen = sc.nextInt();
			int startNode = sc.nextInt();

			// 초기화
			contactList = new ArrayList[101];// 부여될 수 있는 번호는 1~100이하
			for (int i = 0; i < 101; i++) {
				contactList[i] = new ArrayList<>();
			}

			for (int i = 0; i < dataLen / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				// 유향 그래프
				contactList[from].add(new Node(to, 0));
			}

			// 데이터 입력 끝

			contact(new Node(startNode, 0));// 시작

			// 결과출력
			System.out.println("#" + T + " " + LastContactNum);

			// 초기화
			LastContactNum = 0;
			LastContactOrder = 0;
		} // test case end
	}

	public static void contact(Node startNode) {
		Queue<Node> q = new LinkedList<>();
		boolean[] visited = new boolean[101];

		q.add(startNode);
		visited[startNode.num] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			//계속 갱신
			if (LastContactOrder == cur.order) {
				if (LastContactNum < cur.num) {
					LastContactNum = cur.num;
					LastContactOrder = cur.order;
				}
			} else if (LastContactOrder < cur.order) {
				LastContactNum = cur.num;
				LastContactOrder = cur.order;
			}

			for (int i = 0; i < contactList[cur.num].size(); i++) {
				Node next = contactList[cur.num].get(i);

				if (visited[next.num])
					continue;// 방문안한 것만 진행

				q.add(new Node(next.num, cur.order + 1));
				visited[next.num] = true;
			}
		}
	}
}