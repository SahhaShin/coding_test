import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int[] APath; // A 이동 정보
	static int[] BPath; // B 이동 정보
	static int total;// A B 전체 충전 수치
	static int[][] map;
	static BC[] BCList;
	static int M;// 총 이동 시간
	static List<Integer> a_BC, b_BC;

	static class BC {
		int col;// 열 좌표
		int row;// 행 좌표
		int c;// 충전범위
		int p;// 처리량

		public BC(int col, int row, int c, int p) {
			super();
			this.col = col;
			this.row = row;
			this.c = c;
			this.p = p;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();// test case
		for (int T = 1; T <= t; T++) {
			M = sc.nextInt();// 총 이동 시간
			int BCcount = sc.nextInt();// BC의 개수

			// 이동정보 받기
			// 0 : 이동하지 않음
			// 1 : 상
			// 2 : 우
			// 3 : 하
			// 4 : 좌
			APath = new int[M + 1];// 1초부터 이동 위치 받을 예정
			for (int i = 1; i <= M; i++)
				APath[i] = sc.nextInt();

			BPath = new int[M + 1];
			for (int i = 1; i <= M; i++)
				BPath[i] = sc.nextInt();

			map = new int[11][11];// 1부터 인덱스 시작하기 위함
			BCList = new BC[BCcount + 1];// 1번 배터리차지부터 쓸 예정
			// BC 정보 받기
			// i는 BC 번호
			// 겹치는 BC : 1과 2 -> 12 / 1과 3 -> 13 2와 3 -> 23...
			for (int i = 1; i <= BCcount; i++) {
				int col = sc.nextInt();// x
				int row = sc.nextInt();// y
				int c = sc.nextInt();
				int p = sc.nextInt();

				BCList[i] = new BC(col, row, c, p);

				// 지도에 현황 나타내기
				// 열 (x) 행(y)
				// total 몇 번 돌릴지
				int color = 0;// 왼쪽 오른쪽 색칠 갯수
				for (int total = 0; total < c * 2 + 1; total++) {

					// 경계체크
					if (row - c + total < 0 || row - c + total >= 11) {
						color++;
						continue;
					}

					if (map[row - c + total][col] == 0)
						map[row - c + total][col] = i;// 현재 위치 칠하고,
					else
						sameArea(row - c + total, col, i);

					for (int L = 1; L <= color; L++) {
						if (col - L < 0 || col - L >= 11)
							continue;
						if (map[row - c + total][col - L] == 0)
							map[row - c + total][col - L] = i;// 왼쪽 칠하고
						else
							sameArea(row - c + total, col - L, i);
					}
					for (int R = 1; R <= color; R++) {
						if (col + R < 0 || col + R >= 11)
							continue;
						if (map[row - c + total][col + R] == 0)
							map[row - c + total][col + R] = i;// 오른쪽 칠하고
						else
							sameArea(row - c + total, col + R, i);
					}

					if (total < (c * 2 + 1) / 2)
						color++;
					else
						color--;

				}
			} // BC정보 받기 끝

			// 이동 시작 / 계산 시작
			move();

			// 결과 출력
			System.out.println("#" + T + " " + total);

			// 초기화
			total = 0;

		} // TEST CASE END

	}

	// A,B사용자가 1초마다 움직인다.
	private static void move() {
		// 시작점
		int AmoveR = 1;
		int AmoveC = 1;
		int BmoveR = 10;
		int BmoveC = 10;

		for (int time = 0; time <= M; time++) {

			// 사용자가 지도 밖으로 이동하는 경우는 없다고 제시
			if (APath[time] == 1)
				AmoveR--;// A 상 이동
			else if (APath[time] == 2)
				AmoveC++;// A 우 이동
			else if (APath[time] == 3)
				AmoveR++;// A 하 이동
			else if (APath[time] == 4)
				AmoveC--;// A 좌 이동

			if (BPath[time] == 1)
				BmoveR--;// B 상 이동
			else if (BPath[time] == 2)
				BmoveC++;// B 우 이동
			else if (BPath[time] == 3)
				BmoveR++;// B 하 이동
			else if (BPath[time] == 4)
				BmoveC--;// B 좌 이동

			// 이동한 위치에서 배터리 충전하기
			total += charge(map[AmoveR][AmoveC], map[BmoveR][BmoveC]);
		}
	}

	// 배터리 충전
	public static int charge(int A_BC, int B_BC) {
		a_BC = new ArrayList<>();// a 근처에 있는 BC
		b_BC = new ArrayList<>();// b 근처에 있는 BC

		// a의 배터리 차지 뽑아내기
		while (A_BC != 0) {
			a_BC.add(A_BC % 10);
			A_BC /= 10;
		}

		// b의 배터리 차지 뽑아내기
		while (B_BC != 0) {
			b_BC.add(B_BC % 10);
			B_BC /= 10;
		}
        
		// 배터리 최고 수치를 갖는 조합 찾기
		int max = 0;

		// 두명 모두 배터리 차지 안에 있을 때
		for (int a = 0; a < a_BC.size(); a++) {
			for (int b = 0; b < b_BC.size(); b++) {
				// 두 사람이 사용하는 배터리 차지가 같다면 둘 중 하나의 배터리 차지 파워만 가진다.
				if (a_BC.get(a) == b_BC.get(b)) {
					max = Math.max(max, BCList[a_BC.get(a)].p);
				}
				// 두 사람이 사용하는 배터리 차지가 다르다면 더해서 가진다.
				else {
					max = Math.max(max, BCList[a_BC.get(a)].p + BCList[b_BC.get(b)].p);
				}
			}
		}

		// a가 배터리 차지 안에 없을 때 -> b만 들어 있을 때 
		if(a_BC.size()==0) {
			for (int b = 0; b < b_BC.size(); b++) {
				max = Math.max(max, BCList[b_BC.get(b)].p);
			}			
		}
		
		//b가 배터리 차지 안에 없을 때 -> a만 들어있을 때
		if(b_BC.size()==0) {
			for (int a = 0; a < a_BC.size(); a++) {
				max = Math.max(max, BCList[a_BC.get(a)].p);
			}			
		}
		
		return max;
	}

	// 메인 함수에서 2개 이상 영역이 겹치는 공간 처리
	static public void sameArea(int r, int c, int currBC) {
		// 0이 아니면 다른 BC 영역에 있다는 뜻
		if (map[r][c] != 0) {
			map[r][c] = map[r][c] * 10 + currBC;
		}
	}
}