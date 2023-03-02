import java.util.Scanner;

public class Solution {
	//1) 전차 포탄 발사 -> 벽돌 소멸(평지화), 강철벽 그대로
	//전차는 단 하나만 있다.
	static char[][] map;
	static int pocha_x = 0; //포차의 위치
	static int pocha_y = 0; //포차의 위치
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. test case
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			//2. map : h w
			int h=sc.nextInt();
			int w=sc.nextInt();
			map=new char[h][w];
			
			//3. map 셋팅: w길이의 문자열 h만큼
			for(int i=0;i<h;i++) {
				map[i]=sc.next().toCharArray();
			}
					
			// 3-1 포차 위치 찾기
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j]=='^' || map[i][j]=='v' || map[i][j]=='<' || map[i][j]=='>') {
						pocha_x=i;
						pocha_y=j;
					}
				}
			}

			//4. 명령어 길이
			int len = sc.nextInt();
			
			//5. 명령어 입력
			char[] cmd = sc.next().toCharArray();
			
			//6. 연산(len만큼)
			for(int i=0;i<len;i++) {
				switch(cmd[i]) {
				case 'U':
					Up();
					break;
				case 'D':
					Down();
					break;
				case 'L':
					Left();
					break;
				case 'R':
					Right();
					break;
				case 'S':
					Shoot();
					break;
				}
			}
			
			//7. 게임 맵의 상태 변화 출력
			System.out.print("#"+T+" ");
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
		}//test case end
		
	}//main end
	
	//전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
	static public void Up() {
		map[pocha_x][pocha_y]='^';
		int N_r=map.length;
		int N_c=map[0].length;
		//경계 체크
		if((pocha_x-1)>=0 && (pocha_x-1)<N_r && pocha_y>=0 && pocha_y<N_c) {
			if(map[pocha_x-1][pocha_y]=='.') {
				map[pocha_x-1][pocha_y]='^';
				map[pocha_x][pocha_y]='.';
				
				//포차의 위치를 바꿔준다.
				pocha_x=pocha_x-1;
			}
		}
	}
	
	//전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
	static public void Down() {
		map[pocha_x][pocha_y]='v';
		int N_r=map.length;
		int N_c=map[0].length;
		//경계 체크
		if(pocha_x+1>=0 && pocha_x+1<N_r && pocha_y>=0 && pocha_y<N_c) {
			if(map[pocha_x+1][pocha_y]=='.') {
				map[pocha_x+1][pocha_y]='v';
				map[pocha_x][pocha_y]='.';
				
				//포차의 위치를 바꿔준다.
				pocha_x=pocha_x+1;
			}
		}
	}
	
	//전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
	static public void Left() {
		map[pocha_x][pocha_y]='<';
		int N_r=map.length;
		int N_c=map[0].length;
		//경계 체크
		if(pocha_x>=0 && pocha_x<N_r && pocha_y-1>=0 && pocha_y-1<N_c) {
			if(map[pocha_x][pocha_y-1]=='.') {
				map[pocha_x][pocha_y-1]='<';
				map[pocha_x][pocha_y]='.';
				
				//포차의 위치를 바꿔준다.
				pocha_y=pocha_y-1;
			}
		}
	}
	
	//전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
	static public void Right() {
		map[pocha_x][pocha_y]='>';
		int N_r=map.length;
		int N_c=map[0].length;
		//경계 체크
		if(pocha_x>=0 && pocha_x<N_r && pocha_y+1>=0 && pocha_y+1<N_c) {
			if(map[pocha_x][pocha_y+1]=='.') {
				map[pocha_x][pocha_y+1]='>';
				map[pocha_x][pocha_y]='.';
				
				//포차의 위치를 바꿔준다.
				pocha_y=pocha_y+1;
			}
		}
	}
	
	//전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
	//전차 포탄 발사 -> 벽돌 소멸(평지화), 강철벽 그대로
	static public void Shoot() {
		char wich=map[pocha_x][pocha_y];//포차가 바라보고 있는 방향
		int N_r=map.length;
		int N_c=map[0].length;
		
		if(wich=='^') {
			for(int i=pocha_x-1;i>=0;i--) {
				//위쪽에 벽돌로 만들어진 벽이 있다면 평지로 바꿈
				if(map[i][pocha_y]=='*') {
					map[i][pocha_y]='.';
					break;
				}
				//위쪽에 강철로 만들어진 벽이 있다면 무효화
				else if(map[i][pocha_y]=='#') {
					break;
				}
			}
		}//^공격 끝
		
		else if(wich=='v') {
			for(int i=pocha_x+1;i<N_r;i++) {
				//아래쪽에 벽돌로 만들어진 벽이 있다면 평지로 바꿈
				if(map[i][pocha_y]=='*') {
					map[i][pocha_y]='.';
					break;
				}
				//아래쪽에 강철로 만들어진 벽이 있다면 무효화
				else if(map[i][pocha_y]=='#') {
					break;
				}
			}
		}//v공격 끝
		
		else if(wich=='<') {
			for(int i=pocha_y-1;i>=0;i--) {
				//아래쪽에 벽돌로 만들어진 벽이 있다면 평지로 바꿈
				if(map[pocha_x][i]=='*') {
					map[pocha_x][i]='.';
					break;
				}
				//아래쪽에 강철로 만들어진 벽이 있다면 무효화
				else if(map[pocha_x][i]=='#') {
					break;
				}
			}
		}//<공격 끝
		
		else if(wich=='>') {
			for(int i=pocha_y+1;i<N_c;i++) {
				//아래쪽에 벽돌로 만들어진 벽이 있다면 평지로 바꿈
				if(map[pocha_x][i]=='*') {
					map[pocha_x][i]='.';
					break;
				}
				//아래쪽에 강철로 만들어진 벽이 있다면 무효화
				else if(map[pocha_x][i]=='#') {
					break;
				}
			}
		}//>공격 끝
	}

}