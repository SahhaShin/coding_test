import java.util.ArrayList;
import java.util.Scanner;

public class Main {
static ArrayList<CCTV> CCTVList = new ArrayList<>();
	
	static int row_count;
	static int col_count;
	static int[][] map, copyMap;
	
	//type check
	static int[][] drc = {{-1,0},{0,1},{1,0},{0,-1}}; //상 우 하 좌 
	
	static int[] selCCTVMethod;
	
	static int result = 54321;
	
	static class CCTV{
		int row;
		int col;
		int type; //1~5
		
		
		public CCTV(int row, int col, int type) {
			super();
			this.row = row;
			this.col = col;
			this.type = type;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		row_count = sc.nextInt();//세로
		col_count = sc.nextInt();//가로 
		
		map = new int[row_count][col_count];
		
		//map에 데이터 입력받을 때 cctv 위치 체크 (1~5)
		for(int i=0;i<row_count;i++) {
			for(int j=0;j<col_count;j++) {
				map[i][j] = sc.nextInt();
						
				//CCTV 추가 
				if(map[i][j]>=1 && map[i][j]<=5) {
					CCTVList.add(new CCTV(i,j,map[i][j]));
				}
			}
		}
				
		//입력 끝 
		
		selCCTVMethod = new int[CCTVList.size()];
		
		//연산시작 
		DFS(0);
		
		System.out.println(result);
		
		
	}
	
	public static void DFS(int depth) {
		if(depth==CCTVList.size()) {
			
			CopyMap();
			
			for(int i=0;i<CCTVList.size();i++) {
				realDirec(i,selCCTVMethod[i]);//i번째 CCTV가 이 방향으로 갈 것이다.
			}
			result=Math.min(result, CountZeroArea());
			return;
		}
		
		for(int d=0;d<4;d++) {
			selCCTVMethod[depth] = d;
			DFS(depth+1);
		}
	}
	
	public static void realDirec(int n, int method) {
		
		if(CCTVList.get(n).type==1) {
			//상/우/하/좌
			Calculation(n, method); //n번째 CCTV는 이 방향을 감시 
		}else if(CCTVList.get(n).type==2) {
			//상하 / 좌우
			if(method==0 || method==2) {
				//상하 방법 
				Calculation(n, 0);
				Calculation(n, 2);
			}else {
				//좌우 방법 
				Calculation(n, 1);
				Calculation(n, 3);
			}
		}else if(CCTVList.get(n).type==3) {
			//상우 / 우하 / 하좌 / 좌상
			if(method==0) {
				//상우
				Calculation(n, 0);
				Calculation(n, 1);
			}
			else if(method==1) {
				//우하 
				Calculation(n, 1);
				Calculation(n, 2);
			}
			else if(method==2) {
				//하좌 
				Calculation(n, 2);
				Calculation(n, 3);
			}
			else if(method==3) {
				//좌상 
				Calculation(n, 3);
				Calculation(n, 0);
			}
			
		}else if(CCTVList.get(n).type==4) {
			//좌상우 / 상우하 / 우하좌 / 하좌상
			if(method==0) {
				//좌상우
				Calculation(n, 3);
				Calculation(n, 0);
				Calculation(n, 1);
			}
			else if(method==1) {
				//상우하 
				Calculation(n, 0);
				Calculation(n, 1);
				Calculation(n, 2);
			}
			else if(method==2) {
				//우하좌 
				Calculation(n, 1);
				Calculation(n, 2);
				Calculation(n, 3);
			}
			else if(method==3) {
				//하좌상 
				Calculation(n, 2);
				Calculation(n, 3);
				Calculation(n, 0);
			}
			
		}else if(CCTVList.get(n).type==5) {
			//모든방향 
			Calculation(n, 0);
			Calculation(n, 1);
			Calculation(n, 2);
			Calculation(n, 3);
		}
		
	}
	
	public static void Calculation(int n, int direc) {
		
		CCTV curCCTV = CCTVList.get(n);
		int newR = curCCTV.row;
		int newC = curCCTV.col;
		
		while(true) {
			newR += drc[direc][0];
			newC += drc[direc][1];
			
			//범위 체크
			if(newR<0||newR>=row_count||newC<0||newC>=col_count) break;
			
			//벽인지
			if(copyMap[newR][newC]==6) break;
			
			//CCTV인지 
			if(copyMap[newR][newC]>=1 && copyMap[newR][newC]<=5) continue;
			
			//빈공간인지 
			copyMap[newR][newC] = -1;
			
			
		}
		
	}
	
	public static void CopyMap() {
		copyMap = new int[row_count][col_count];
		
		for(int i=0;i<row_count;i++) {
			System.arraycopy(map[i], 0, copyMap[i], 0, col_count);
		}
	}
	
	public static int CountZeroArea() {
		int count = 0;
		
		for(int i=0;i<row_count;i++) {
			for(int j=0;j<col_count;j++) {
				if(copyMap[i][j]==0) {
					count++;
				}
			}
		}
		return count;
	}
}