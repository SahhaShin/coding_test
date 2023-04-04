import java.util.List;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] map;

	static Hole[] holePair;// 0 : hole 5(1) - 1: hole5(2)
	static int holeCount;// 홀 전체 갯수

	static int[][] blackHole;// 블랙홀 행 열 저장
	static int blackCount;// 블랙홀이 있는지 없는지

	static int[][] direc;// 핀볼이 블록 치면 가는 위치

	static int score;// 핀볼 점수

	static boolean[][] visited;// 해당 시작지점에서 이미 시작을 했는지 알려준다.

	static class Hole {
		int r;
		int c;
		int num;

		public Hole(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int T = 1; T < t + 1; T++) {

			N = sc.nextInt();// 배열 크기

			map = new int[N + 2][N + 2];// 게임 맵 선언
			int holeIdx = 0;
			// 웜홀 블랙홀 위치 함께 체크
			holePair = new Hole[10];// 홀 페어는 최대 5쌍
			blackHole = new int[1][2];// 블랙홀 행 열 저장

			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {

					// 가장자리 하나 더 크게 만들었음, 벽을 만나면 반대방향, 블록으로 처리
					if (i == 0 || j == 0 || i == N + 1 || j == N + 1)
						map[i][j] = 5;
					else
						map[i][j] = sc.nextInt();

					// 웜홀 위치 저장
					if (map[i][j] >= 6 && map[i][j] <= 10) {
						holeCount++;// 전체 홀을 1 증가시킨다.
						holePair[holeIdx++] = new Hole(i, j, map[i][j]);// 홀 리스트에 추가
					}

					// 블랙홀 위치 저장
					if (map[i][j] == -1) {
						blackHole[0][0] = i;
						blackHole[0][1] = j;
						blackCount++;
					}
				}
			}

			
			// 게임 지도 입력 끝

			// 블록에 따른 핀볼 위치 지정 상(0) 하(1) 좌(2) 우(3)
			direc = new int[6][4];
			direc[1][0] = 1;// 내가 1번 삼각형 아래쪽을 위(0)로치면 아래쪽으로 핀볼을 튕긴다.
			direc[1][1] = 3;// 내가 1번 삼각형 위쪽을 아래(1)로치면 오른쪽으로 핀볼을 튕긴다.
			direc[1][2] = 0;// 내가 1번 삼각형 오른쪽을 왼쪽(2)으로치면 위쪽으로 핀볼을 튕긴다.
			direc[1][3] = 2;// 내가 1번 삼각형 왼쪽을 오른쪽(3)으로치면 아래쪽으로 핀볼을 튕긴다.

			direc[2][0] = 3;// 내가 2번 삼각형 아래쪽을 위(0)로치면 오른쪽으로 핀볼을 튕긴다.
			direc[2][1] = 0;// 내가 2번 삼각형 위쪽을 아래(1)로치면 위쪽으로 핀볼을 튕긴다.
			direc[2][2] = 1;// 내가 2번 삼각형 오른쪽을 왼쪽(2)으로치면 아래쪽으로 핀볼을 튕긴다.
			direc[2][3] = 2;// 내가 2번 삼각형 왼쪽을 오른쪽(3)으로치면 아래쪽으로 핀볼을 튕긴다.

			direc[3][0] = 2;// 내가 3번 삼각형 아래쪽을 위(0)로치면 왼쪽으로 핀볼을 튕긴다.
			direc[3][1] = 0;// 내가 3번 삼각형 위쪽을 아래(1)로치면 위쪽으로 핀볼을 튕긴다.
			direc[3][2] = 3;// 내가 3번 삼각형 오른쪽을 왼쪽(2)으로치면 오른쪽으로 핀볼을 튕긴다.
			direc[3][3] = 1;// 내가 3번 삼각형 왼쪽을 오른쪽(3)으로치면 아래쪽으로 핀볼을 튕긴다.

			direc[4][0] = 1;// 내가 4번 삼각형 아래쪽을 위(0)로치면 아래쪽으로 핀볼을 튕긴다.
			direc[4][1] = 2;// 내가 4번 삼각형 위쪽을 아래(1)로치면 왼쪽으로 핀볼을 튕긴다.
			direc[4][2] = 3;// 내가 4번 삼각형 오른쪽을 왼쪽(2)으로치면 오른쪽으로 핀볼을 튕긴다.
			direc[4][3] = 0;// 내가 4번 삼각형 왼쪽을 오른쪽(3)으로치면 위쪽으로 핀볼을 튕긴다.

			direc[5][0] = 1;// 내가 5번 삼각형 아래쪽을 위(0)로치면 아래쪽으로 핀볼을 튕긴다.
			direc[5][1] = 0;// 내가 5번 삼각형 위쪽을 아래(1)로치면 위쪽으로 핀볼을 튕긴다.
			direc[5][2] = 3;// 내가 5번 삼각형 오른쪽을 왼쪽(2)으로치면 오른쪽으로 핀볼을 튕긴다.
			direc[5][3] = 2;// 내가 5번 삼각형 왼쪽을 오른쪽(3)으로치면 왼쪽으로 핀볼을 튕긴다.

			// 게임시작
			visited = new boolean[N][N];
			startPoint();

			// 결과 도출
			System.out.println("#" + T + " " + score);

			// 초기화
			holeCount = 0;
			blackCount = 0;
			score = 0;
		} // test case end
	}// main end

	/**
	 * 시작 지점은 0에서 시작한다. 블랙홀, 웜홀이 없을 수 있다. 점수는 오로지 벽이나 블록에 부딪힌 횟수이다. 핀볼은 상 하 좌 우 중
	 * 4방을 움직인다. 블랙홀에 빠질 때 게임이 종료된다. 또는 핀볼이 출발 위치로 돌아오면 종료된다. 이 함수에서 게임이 끝난다는 것은 많은
	 * 시작점 중 하나의 시작점에서 시작했을 때 게임이 끝났다는 것이다. 진짜 모든 게임이 끝나는 순간은 startPoint함수가 종료되는
	 * 시점이다.
	 * 
	 * 게임 점수의 최댓값을 찾아라
	 */
	public static void pinBallGame(int startR, int startC) {
		int[][] drc= {{-1,0},{1,0},{0,-1},{0,1}};//상 하 좌 우
		int nextR = startR;
		int nextC = startC;
		//4방 중 어디를 갈지 정한다.
		//내가 가고있는 방향도 저장한다. 상(0) 하(1) 좌(2) 우(3)
		int myDirec=0;//초기화
		
		for(int d=0;d<4;d++) {
			int bump = 0;//점수와 다름없다. 시작점으로부터 4방향을 갈건데 점수는 모두 달라야 하니까 여기서 초기화
			
			int row = nextR+drc[d][0];
			int col = nextC+drc[d][1];
		
			if(d==0) myDirec=0;
			else if(d==1) myDirec=1;
			else if(d==2) myDirec=2;
			else if(d==3) myDirec=3;
			//블랙홀에 들어가면 게임을 멈춘다.
			//시작지점으로 다시 오면 게임을 멈춘다.
			while((blackHole[0][0]!=row || blackHole[0][1]!=col) && (row!=startR || col !=startC)) {
				//블록/웜홀/블랙홀을 만나지 않는 한 현재 방향 유지 == 직진
				if(map[row][col]==0) {
					//나의 직진이 상 쪽이면 상 쪽으로 직진
					if(myDirec==0) row += -1;
					
					//나의 직진이 하 쪽이면 하 쪽으로 직진
					else if(myDirec==1) row += 1;
					
					//나의 직진이 좌 쪽이면 좌 쪽으로 직진
					else if(myDirec==2) col -= 1;
					//나의 직진이 우 쪽이면 우 쪽으로 직진
					else if(myDirec==3) col += 1;
				}
				
				//블록을 만났다면 방향 턴
				//근데 5번 블록을 만나면 왔던 길로 다시 돌아가기 떄문에 2배해주고 끝내면 된다.
				else if(map[row][col]>=1 && map[row][col]<=5) {
					int blockNum = map[row][col];
					myDirec=direc[blockNum][myDirec];
					
					//나의 직진이 상 쪽이면 상 쪽으로 직진
					if(myDirec==0) row += -1;
					
					//나의 직진이 하 쪽이면 하 쪽으로 직진
					else if(myDirec==1) row += 1;
					
					//나의 직진이 좌 쪽이면 좌 쪽으로 직진
					else if(myDirec==2) col -= 1;
					//나의 직진이 우 쪽이면 우 쪽으로 직진
					else if(myDirec==3) col += 1;
					
					if(blockNum==5) {
						bump = bump*2+1;
						break;
					}
					else bump++;
				}
				
				//웜홀을 만났다면 워프 방향은 그대로
				else if(map[row][col]>=6 && map[row][col]<=10) {
					for(int i=0;i<holeCount;i++) {
						//웜홀 페어 대상을 찾았다.
						if(holePair[i].num == map[row][col]) {
							//현재 웜홀 위치와 다른 페어를 찾았다.
							if(holePair[i].r!=row || holePair[i].c!=col) {
								
								//웜홀에서 나와 직진 한 칸해야한다.
								
								//나의 직진이 상 쪽이면 상 쪽으로 직진
								if(myDirec==0) {
									row = holePair[i].r-1;
									col = holePair[i].c;
								}
								//나의 직진이 하 쪽이면 한 쪽으로 직진
								else if(myDirec==1) {
									row = holePair[i].r+1;
									col = holePair[i].c;
								}
								//나의 직진이 좌 쪽이면 좌 쪽으로 직진
								else if(myDirec==2) {
									row = holePair[i].r;
									col = holePair[i].c-1;
								}
								//나의 직진이 우 쪽이면 우 쪽으로 직진
								else if(myDirec==3) {
									row = holePair[i].r;
									col = holePair[i].c+1;
								}
								
							}
						}
					}
				}//웜홀 연산 종료
				
				//블랙홀을 만나면 게임 종료
				else if(map[row][col]==-1) break;
				
				//시작점 만나면 게임 종료
				else if(row==startR && col ==startC) break;
				
				
			}//while end
			
			//한 방향 연산 종료했으니 점수 최고값 비교한다.
			score = Math.max(score, bump);
			
		}//여기서 나왔다는 것은 시작지점으로부터 4방향으로 모두 가봤다는 뜻이다.
	}

	/**
	 * 시작 지점을 알려주는 함수 시작지점을 정해서 핀볼 게임 진입
	 */
	public static void startPoint() {
		// 시작지점 구하기
		for (int startR = 1; startR <= N; startR++) {
			for (int startC = 1; startC <= N; startC++) {
				if (map[startR][startC] != 0)
					continue;

				else
					pinBallGame(startR, startC);
			}
		}
	}

}