import java.util.*;

public class Solution {
	
	static int[][] arr;
	static int[][] direc = {{1,0}, {0,-1}, {0,1}};
	static int[][] curr_location;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int T=1;T<=10;T++) {
			int test_num = sc.nextInt();
			arr = new int[100][100];
			
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			//입력 끝
			
			//1. 맨 밑에서 도착 2를 찾는다.
			int goal_col = 0;  //row는 99로 fix
			for(int i=0;i<100;i++) {
				if(arr[99][i]==2) {
					goal_col=i;
					break;
				}
			}
			
			//2. 기본 위로 가다가 양 옆에 갈 수 있는 선택지가 나오면
			//기본 위로 가다가 좌 우 둘다 있으면 좌로 
			//상(0) 좌(1) 우(2)
			int direction = 0;
			curr_location = new int[1][2];
			
			curr_location[0][0] = 99;
			curr_location[0][1] = goal_col;
			
			while(curr_location[0][0]>0) {
				if(direction==0) {
					curr_location[0][0]--;
					
					//다음 갈 방향 선정 
					
					//하나 올라갔는데 좌가 있어
					if(curr_location[0][1]-1>=0 && arr[curr_location[0][0]][curr_location[0][1]-1]==1) {
						direction=1;
					}
					
					//하나 올라갔는데 우가 있어
					else if(curr_location[0][1]+1<100 && arr[curr_location[0][0]][curr_location[0][1]+1]==1) {
						direction=2;
					}
					
				}
				
				else if(direction==1) {
					
					curr_location[0][1]--;
					
					//다음 갈 방향 선정 
					
					//좌가 더 있냐 그럼 좌로 가 
					if(curr_location[0][1]-1>=0 && arr[curr_location[0][0]][curr_location[0][1]-1]==1) {
						direction=1;
					}
					
					//좌로 갔는데 좌가 또 없고, 위가 있어 
					else if(curr_location[0][0]-1>=0 && arr[curr_location[0][0]-1][curr_location[0][1]]==1) {
						direction=0;
					}
					
					//좌로 갔는데 좌도 없고, 위도 없어 그럼 다시 원상복구하고, 우로 갈 수 있게 해야함
					else {
						curr_location[0][1]++;
						direction=2;
					}
				}
				
				else if(direction==2) {
					
					curr_location[0][1]++;
					
					//다음 갈 방향 선정 
					
					//우가 더 있냐 그럼 우로 가 
					if(curr_location[0][1]+1<100 && arr[curr_location[0][0]][curr_location[0][1]+1]==1) {
						direction=2;
					}
					
					//우로 갔는데 우가 또 없고, 위가 있어 
					else if(curr_location[0][0]-1>=0 && arr[curr_location[0][0]-1][curr_location[0][1]]==1) {
						direction=0;
					}
					
					//우로 갔는데 우도 없고, 위도 없어 그럼 다시 원상복구하고, 좌로 갈 수 있게 해야함
					else {
						curr_location[0][1]--;
						direction=1;
					}
				}
			}//while end
			
			//y좌표 출력
			System.out.println("#"+T+" "+curr_location[0][1]);
		}//test case end
	}
}