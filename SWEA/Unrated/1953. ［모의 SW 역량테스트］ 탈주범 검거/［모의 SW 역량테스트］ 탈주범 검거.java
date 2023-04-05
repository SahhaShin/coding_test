import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] map;
	static boolean[][] visited;
	static int N,M;
	
	static class Location{
		int r;
		int c;
		public Location(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Location [r=" + r + ", c=" + c + "]";
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//test case
		
		for(int T=1;T<t+1;T++) {
			N = sc.nextInt();//세로의 크기
			M = sc.nextInt();//가로의 크기
			int R = sc.nextInt();//맨홀 세로위치
			int C = sc.nextInt();//맨홀 가로위치
			int L = sc.nextInt();//탈출 후 소요된 시간
			
			//지하 터널 정보
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					map[i][j]=sc.nextInt();
					if(map[i][j]==0) visited[i][j]=true;
				}
			}
			//입력 받기 끝
			
			//범인 검거 시작
			int result=detect(R,C,L);
			
			//결과 출력
			System.out.println("#"+T+" "+result);
		}
	}
	
	public static int detect(int startR, int startC, int pastTime) {
		Queue<Location> q = new LinkedList<>();
		//터널 구조물 타입 1. 사방탐색 -> 상 하 좌 우
		int[][] drc1 = {{-1,0},{1,0},{0,-1},{0,1}};
		//터널 구조물 타입 2. 상 하 탐색 -> 상 하
		int[][] drc2 = {{-1,0},{1,0}};
		//터널 구조물 타입 3. 좌 우 탐색 -> 좌 우
		int[][] drc3 = {{0,-1},{0,1}};
		//터널 구조물 타입 4. 상 우 탐색 -> 상 우
		int[][] drc4 = {{-1,0},{0,1}};
		//터널 구조물 타입 5. 하 우 탐색 -> 하 우
		int[][] drc5 = {{1,0},{0,1}};
		//터널 구조물 타입 6. 하 좌 탐색 -> 하 좌
		int[][] drc6 = {{1,0},{0,-1}};
		//터널 구조물 타입 7. 상 좌 탐색 -> 상 좌
		int[][] drc7 = {{-1,0},{0,-1}};
		
		int location=0;
		
		//일단 1시간 경과 시 갈 수 있는 곳은 맨홀 위치 1곳뿐
		location++;
		visited[startR][startC]=true;
		q.add(new Location(startR, startC));
		
		int row=startR;
		int col=startC;
		
		//터널별 탐색 시작
		//같은 타임에 몇개의 후보가 들어왔는지 체크해야함
		int fix=1;
		int count=1;
		
		for(int time=2; time<=pastTime;time++) {
			fix=count;
			count=0;
			for(int p=0;p<fix;p++) {
				
				Location curr = q.poll();
				
				if(curr==null) break;
				
				if(map[curr.r][curr.c]==0) continue;
				
				if(map[curr.r][curr.c]==1) {
					for(int d=0;d<4;d++) {
						row = curr.r+drc1[d][0];
						col = curr.c+drc1[d][1];
						if(row<0 || row>=N || col<0 || col>=M) continue;
						if(d==0 && (map[row][col]==3 ||map[row][col]==4 || map[row][col]==7)) continue;
						if(d==1 && (map[row][col]==3 ||map[row][col]==5 || map[row][col]==6)) continue;
						if(d==2 && (map[row][col]==2 ||map[row][col]==6 || map[row][col]==7)) continue;
						if(d==3 && (map[row][col]==2 ||map[row][col]==4 || map[row][col]==5)) continue;
						
						if(!visited[row][col]) {
							visited[row][col]=true;
							location++;
							count++;
							q.add(new Location(row, col));
						}
					}
				}//터널 1 끝 - 상 하 좌 우
				
				else if(map[curr.r][curr.c]==2) {
					for(int d=0;d<2;d++) {
						row = curr.r+drc2[d][0];
						col = curr.c+drc2[d][1];
						if(row<0 || row>=N || col<0 || col>=M) continue;
						if(d==0 && (map[row][col]==3 ||map[row][col]==4 || map[row][col]==7)) continue;
						if(d==1 && (map[row][col]==3 ||map[row][col]==5 || map[row][col]==6)) continue;
						
						if(!visited[row][col]) {
							visited[row][col]=true;
							location++;
							count++;
							q.add(new Location(row, col));
						}
					}
				}//터널 2 끝 - 상 하
				
				else if(map[curr.r][curr.c]==3) {
					for(int d=0;d<2;d++) {
						row = curr.r+drc3[d][0];
						col = curr.c+drc3[d][1];
						if(row<0 || row>=N || col<0 || col>=M) continue;
						if(d==0 && (map[row][col]==2 ||map[row][col]==6 || map[row][col]==7)) continue;
						if(d==1 && (map[row][col]==2 ||map[row][col]==4 || map[row][col]==5)) continue;
						
						if(!visited[row][col]) {
							visited[row][col]=true;
							location++;
							count++;
							q.add(new Location(row, col));
						}
					}
				}//터널 3 끝 - 좌 우
				
				else if(map[curr.r][curr.c]==4) {
					for(int d=0;d<2;d++) {
						row = curr.r+drc4[d][0];
						col = curr.c+drc4[d][1];
						if(row<0 || row>=N || col<0 || col>=M) continue;
						if(d==0 && (map[row][col]==3 ||map[row][col]==4 || map[row][col]==7)) continue;
						if(d==1 && (map[row][col]==2 ||map[row][col]==4 || map[row][col]==5)) continue;
						
						if(!visited[row][col]) {
							visited[row][col]=true;
							location++;
							count++;
							q.add(new Location(row, col));
						}
					}
				}//터널 4 끝 - 상 우
				
				else if(map[curr.r][curr.c]==5) {
					for(int d=0;d<2;d++) {
						row = curr.r+drc5[d][0];
						col = curr.c+drc5[d][1];
						if(row<0 || row>=N || col<0 || col>=M) continue;
						if(d==0 && (map[row][col]==3 ||map[row][col]==5 || map[row][col]==6)) continue;
						if(d==1 && (map[row][col]==2 ||map[row][col]==4 || map[row][col]==5)) continue;
						
						if(!visited[row][col]) {
							visited[row][col]=true;
							location++;
							count++;
							q.add(new Location(row, col));
						}
					}
				}//터널 5 끝 - 하 우
				
				else if(map[curr.r][curr.c]==6) {
					for(int d=0;d<2;d++) {
						row = curr.r+drc6[d][0];
						col = curr.c+drc6[d][1];
						if(row<0 || row>=N || col<0 || col>=M) continue;
						if(d==0 && (map[row][col]==3 ||map[row][col]==5 || map[row][col]==6)) continue;
						if(d==1 && (map[row][col]==2 ||map[row][col]==6 || map[row][col]==7)) continue;
						
						if(!visited[row][col]) {
							visited[row][col]=true;
							location++;
							count++;
							q.add(new Location(row, col));
						}
					}
				}//터널 6 끝 - 하 좌
				
				else if(map[curr.r][curr.c]==7) {
					for(int d=0;d<2;d++) {
						row = curr.r+drc7[d][0];
						col = curr.c+drc7[d][1];
						if(row<0 || row>=N || col<0 || col>=M) continue;
						if(d==0 && (map[row][col]==3 ||map[row][col]==4 || map[row][col]==7)) continue;
						if(d==1 && (map[row][col]==2 ||map[row][col]==6 || map[row][col]==7)) continue;
						
						if(!visited[row][col]) {
							visited[row][col]=true;
							location++;
							count++;
							q.add(new Location(row, col));
						}
					}
				}//터널 7 끝 - 상 좌
			}//p end
		}//time end
		
		return location;
	}
}