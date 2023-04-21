import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Node>[] adjList;
	static boolean[] visited;
	static int result;

	static class Node {
		int num;
		int distance;

		public Node(int num, int distance) {
			super();
			this.num = num;
			this.distance = distance;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 노드개수
		int M = sc.nextInt();// 알고싶은 거리 개수

		// 초기화
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 거리정보 입력
		for (int i = 0; i < N - 1; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			int distance = sc.nextInt();

			// 무향
			adjList[node1].add(new Node(node2, distance));
			adjList[node2].add(new Node(node1, distance));
		}

		// 알고싶은 간선 정보 입력
		for (int i = 0; i < M; i++) {
			result = 0;
			visited = new boolean[N + 1];
			int start = sc.nextInt();
			int end = sc.nextInt();
			visited[start] = true;
			Distance(start, end, 0);
		}
	}

	public static void Distance(int start, int end, int result) {

		if (start == end) {
			System.out.println(result);
			return;
		}

		for (int j = 0; j < adjList[start].size(); j++) {

			if (visited[adjList[start].get(j).num])
				continue;

			visited[adjList[start].get(j).num] = true;

			Distance(adjList[start].get(j).num, end, result + adjList[start].get(j).distance);
		}
	}
}