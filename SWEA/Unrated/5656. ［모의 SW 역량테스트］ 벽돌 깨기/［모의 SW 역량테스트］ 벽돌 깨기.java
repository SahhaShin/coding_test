import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static int[][] map, copyMap;
	static int N, W, H;
	static int totalBrick;// 전체 벽돌
	static int maxBrick;// 가장 많이 깨진 벽돌수
	static int[] sel;// 내가 벽돌을 깨기 위해 선택한 위치
	static int[] remain, copyRemain;// 각 열의 벽돌 남은 갯수
	static int bum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();// test case

		for (int T = 1; T <= t; T++) {
			N = sc.nextInt();// 떨어뜨릴 횟수
			W = sc.nextInt();// 넓이 열
			H = sc.nextInt();// 높이 행

			sel = new int[N];

			// 게임 정보 받기
			// 벽돌 전체갯수 받아야함 -> 나중에 남은 벽돌 갯수 세주기 위함
			map = new int[H][W];
			copyMap = new int[H][W];
			remain = new int[W];
			copyRemain = new int[W];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
					copyMap[i][j] = map[i][j];
					if (map[i][j] > 0) {
						totalBrick++;// 전체 벽돌 추가
						remain[j]++;
						copyRemain[j]++;
					}
				}
			}

			// 구현
			where(0);

			// 결과는 벽돌 남은 개수
			System.out.println("#" + T + " " + (totalBrick - maxBrick));

			// 초기화
            maxBrick = 0;
			totalBrick=0;
			bum=0;

		} // test case end
	}

	/**
	 * 어디에 구슬을 치면 좋을지 위치 선정하는 함수 구슬 떨어뜨릴 횟수만큼 위치 선정 후 가장 많이 터뜨린 벽돌 수 비교 결과는 벽돌 남은
	 * 갯수라는 걸 인지할 것 중복 순열을 이용함
	 */
	public static void where(int depth) {
		if (depth == N) {

			for (int i = 0; i < N; i++) {

				int hit = 0;
				if (H - remain[sel[i]] < H)
					hit = map[H - remain[sel[i]]][sel[i]] - 1;

				int row = H - remain[sel[i]];
				if (row >= H) {
					// 남아있는 벽돌이 없다는 뜻 -> 하나도 터뜨리지 못한다는 뜻
					continue;
				}

				bump(row, sel[i], hit); // sel은 static이니까 넘겨 줄 필요 없다.
				stick();
				
			}
			maxBrick = Math.max(bum, maxBrick);
			bum = 0;

			// 원복
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = copyMap[i][j];
				}
			}

			for (int i = 0; i < W; i++) {
				remain[i] = copyRemain[i];
			}

			return;
		}

		if (sel[depth] == W)
			return;

		for (int wich = 0; wich < W; wich++) {
			sel[depth] = wich;// 열 위치를 저장
			where(depth + 1);
		}
	}

	/**
	 * //내가 지금 치려고 하는 곳 int col = sel[depth]; int row = H-remain[col]; -> 이 정보가
	 * 넘어온다.
	 * 
	 * 
	 * //우리는 상하좌우로 각 방향마다 몇 번씩 쳐야하는가? int hit = map[row][col]-1;
	 */
	public static void bump(int row, int col, int hit) {

		// 상하좌우
		int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		// 시작점부터 부시기
		if (map[row][col] > 0) {
			map[row][col] = 0;
			remain[col]--;
			bum++;
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= hit; j++) {
				int moveR = row + drc[i][0] * j;
				int moveC = col + drc[i][1] * j;
				// 경계검사
				if (moveR < 0 || moveR >= H || moveC < 0 || moveC >= W)
					continue;

				if (map[moveR][moveC] == 0)
					continue;

				else if (map[moveR][moveC] == 1) {
					if (map[moveR][moveC] > 0) {
						map[moveR][moveC] = 0;
						remain[moveC]--;
						bum++;

					}

					continue;
				} else {
					bump(moveR, moveC, map[moveR][moveC] - 1);// 재귀
				}
			}
		}

	}

	/**
	 * 공중부양하는 블록들 붙이는 함수
	 * 한 열 둘러보면서 1 이상인 수를 스택에 넣는다.
	 * 다 둘러봤으면 뒤에서부터 스택에서 요소를 빼주고 채워준다.
	 */
	public static void stick() {
		Stack<Integer> stack = new Stack();
		
		for(int i=0;i<W;i++) {
			for(int j=0;j<H;j++) {
				if(map[j][i]>=1) {
					stack.add(map[j][i]);
					map[j][i]=0;
				}
			}//한 열 정리 끝
			int idx = H-1;
			while(!stack.isEmpty()) {
				map[idx--][i]=stack.pop();
			}
		}
	}

}
