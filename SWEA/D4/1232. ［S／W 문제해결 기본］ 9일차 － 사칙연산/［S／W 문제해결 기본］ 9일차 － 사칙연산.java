import java.util.Scanner;

public class Solution {

	// 숫자는 바로 트리로 넣고, 연산자는 스택에 넣었다가
	// 연산자가 새로 들어오면 우선순위에 따라 트리에 넣기
	static String[][] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int T = 1; T < 11; T++) {
			// 정점 번호가 정수면 정점번호+양의정수
			// 정점 연산자면 정점번호+연산자+왼쪽+오른쪽

			// 1. 몇개의 케이스를 받을 것인가?
			int t = sc.nextInt();
			// 0번 인덱스 안쓸 것임
			// [][0] : 나의 데이터
			// [][1] : left 자식
			// [][2] : right 자식
			tree = new String[t + 1][3];

			// 케이스만큼 돌아간다.
			for (int tc = 1; tc < t + 1; tc++) {
				// 2. 정점번호
				int num = sc.nextInt();// 1
				String op = sc.next(); // 정수냐 연산자냐 -> 정수면 정점 값임

				// 3. op이 연산자면 왼쪽 노드 오른쪽 노드 값 받아라
				if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
					// num 인덱스에 op값이 들어감
					tree[num][0] = op; // + - * /
					int L = sc.nextInt();// 왼쪽 노드 인덱스
					int R = sc.nextInt();// 오른쪽 노드 인덱스
					tree[num][1] = Integer.toString(L);
					tree[num][2] = Integer.toString(R);

				}
				// 4. op가 숫자면 그게 노드 값이 됨
				else {
					tree[num][0] = op; // 10 88 65
				}
			} // 여기까지 배열 입력 완료 예를 들어 케이스 3개

			// 5. 끝 노드부터 2개 자식을 구하고, 그 자식들의 부모 연산자를 뽑아서 계산
			// 계산 후 부모 인덱스에 결과 넣어주고, 이전 부모의 자식들을 뽑아서 부모 연산자로 계산 -> 그걸 부모에 넣어줌
			// 부모가 1인 연산자들이 계산을 끝냈다면 끝

			// t가 끝 케이스임

			// 끝 인덱스의 부모먼저 연산 시작
			int pa = t;// 첫 시작 부모 인덱스 찾기
			for (int i = t; i > 0; i--) {
				// left값이 있으면 부모임
				if (tree[i][1] != null) {
					pa = i;
					break;
				} else
					pa = 0;
			}
			while (pa > 0) {
				int left = Integer.parseInt(tree[pa][1]);
				int right = Integer.parseInt(tree[pa][2]);
				int result = 0;
				
				if (tree[pa][0].equals("+"))
					result = Integer.parseInt(tree[left][0]) + Integer.parseInt(tree[right][0]);
				else if (tree[pa][0].equals("-"))
					result = Integer.parseInt(tree[left][0]) - Integer.parseInt(tree[right][0]);
				else if (tree[pa][0].equals("*"))
					result = Integer.parseInt(tree[left][0]) * Integer.parseInt(tree[right][0]);
				else if (tree[pa][0].equals("/"))
					result = Integer.parseInt(tree[left][0]) / Integer.parseInt(tree[right][0]);

				// 연산 결과를 부모 트리에 넣어줘

				tree[pa][0] = Integer.toString(result);
				tree[pa][1] = null;
				tree[pa][2] = null;
			
				// 마지막 전 부모를 계속 찾아가기
				for (int i = t; i > 0; i--) {
					// left값이 있으면 부모임
					if (tree[i][1] != null) {
						pa = i;
						break;
					} else {
						pa = 0;
					}
				}

			}
			// 6.결과값은
			// #1 13
			// #2 20

			System.out.println("#" + T + " " + tree[1][0]);// 결과값은 1번 인덱스에 있음
		} // test case end
	}

}
