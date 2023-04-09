import java.util.Scanner;

public class Solution {
	// 전체 집 수 대비 낼 수 있는 금액을 계산한다.
	// 범위를 운영비용 고려해서 이득 볼 수 있게 범위 설정
	// 예를 들어 11개집이 3원씩 낼 수 있어 => 33
	// K=5 25+16 = 41 때문에 최대 범위 4(운영비용 25)를 채택
	// K=1은 할 필요가 없다 왜냐하면 최대 금액이 M이기 때문
	static int N, M, houseCount;
	static int[][] map;
	static int maxHouse = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int T = 1; T < t + 1; T++) {
			N = sc.nextInt();// 도시의 크기
			M = sc.nextInt();// 지불할 수 있는 비용

			// 초기화
			map = new int[N][N];

			// 데이터 받으면서 집의 수 체크
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1)
						houseCount++;
				}
			}

			// 입력 받기 끝

			// 집 수 고려해 최대 서비스 영역 구하기
			// 운영 비용 = K * K + (K - 1) * (K - 1)
			int maxK = 1;// 최대 서비스 영역
			int profit = houseCount * M;
			while (true) {
				int runningFee = maxK * maxK + (maxK - 1) * (maxK - 1);
				if (runningFee > profit) {
					maxK--;
					break;
				} else
					maxK++;
			}

			for (int range = 2; range <= maxK; range++) {
				CountHouse(range);
			}

			// 결과출력
			System.out.println("#" + T + " " + maxHouse);

			// 초기화
			houseCount = 0;
			maxHouse = 1;
		} // test case end
	}

	// 일정 범위 내에 들어오는 최대 집수를 구하는 함수
	public static void CountHouse(int range) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int fill = 0;// 왼쪽 오른쪽 검사할 수 있는 횟수
				int house = 0;
				int start = i - (range - 1);
				for (int k = start; k < start+(range - 1) * 2 + 1; k++) {

					// 나 자신 검사
					if (k >= 0 && k < N && j >= 0 && j < N) {
						if (map[k][j] == 1)
							house++;
					}

					// 왼쪽/오른쪽 검사
					for (int LR = 1; LR <= fill; LR++) {
						// 범위 체크 후 범위 내 집이 있다면 ++
						if (k >= 0 && k < N && j - LR >= 0 && j - LR < N) {
							if (map[k][j - LR] == 1)
								house++;
						}
						if (k >= 0 && k < N && j + LR >= 0 && j + LR < N) {
							if (map[k][j + LR] == 1)
								house++;
						}
					} // LR end
						// (i,j)는 정중앙 위치이다.
					if (k < i)
						fill++;
					else
						fill--;
				} // k end (i,j)위치에서 서비스 받을 수 있는 집 모두 구했다.
				
				int profit = (house * M) - ((range * range) + ((range - 1) * (range - 1)));
				
				if (profit>=0 && maxHouse<house) {
					maxHouse = house;
				}
			} // j end
		} // i end
	}

}