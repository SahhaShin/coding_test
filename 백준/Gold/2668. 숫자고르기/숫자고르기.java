import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 1. 1번 인덱스부터 조사를 시작한다. 2. 싸이클이 생기면 선택할 수 있다는 의미이다. 3. 싸이클이 생기면 visited = true로
 * 바꾼다. 4. 싸이클이 안생기면 visited = false로 초기화한다.
 */

public class Main{
	static int N;
	static int[] arr;
	static int resultLen;
	static boolean[] visited;// 결국 방문한 인덱스만 결과로 뽑아내면 된다.
	static PriorityQueue<Integer> recur;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		// 초기화
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		// 데이터 입력받기 끝

		// 인덱스 하나씩 돌면서 사이클이 생기는지 확인할 것임
		for (int i = 1; i <= N; i++) {
			recur = new PriorityQueue<>();// 매 순환 체크 마다 새로운 큐
			// 순환하지 않는다면 visited=false처리 -> 결과반영 x
			if (!DFS(i, i, 1)) {
				while (!recur.isEmpty()) {
					int target = recur.poll();
					visited[target] = false;
				}
			}
		}

		// 결과 출력
		System.out.println(resultLen);
		for (int i = 1; i <= N; i++) {
			if (visited[i])
				System.out.println(i);
		}
	}

	public static boolean DFS(int index, int startIdx, int len) {
		//처음에 들어오는것도 방문했으면 넣지 않기
		if(!visited[index]) {			
			recur.add(index);
			visited[index] = true;
		}
		
		// 순환을 돌아 시작점으로 다시 돌아왔다면 사이클이 완성된 것이다.
		if (arr[index] == startIdx) {
			resultLen += len;
			return true;
		}

		// 순환을 돌아야 한다면 dfs속으로!
		if (!visited[arr[index]])
			return DFS(arr[index], startIdx, len + 1);
		
		return false;
	}
}