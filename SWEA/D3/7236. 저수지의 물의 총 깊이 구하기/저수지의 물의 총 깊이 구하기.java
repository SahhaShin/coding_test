import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		// 1. test case
		int tc = sc.nextInt();//3
		
		//상 하 좌 우 좌상 우상 좌하 우하 
		int[][] drc= {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
		
		for(int T=1;T<tc+1;T++) {
			//2. NxN
			int N = sc.nextInt();//6
			sc.nextLine();//개행문자 입력 방지 
			
			//3. nxn data 입력 
			String[][] ground=new String[N][N];
			for(int r=0;r<N;r++) {
				ground[r] = sc.nextLine().split(" "); //G W G G W W
			}
			
			//4. 주변 8곳의 W수를 체크한다.
			//체크 후 가장 큰 값을 구해야함
			//주변에 모두 G이고 나혼자 W면 1임
			int count=0;
			int max=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					count=0;//초기화
					if(ground[i][j].equals("W")) {
						//8방을 조사한다.
						for(int k=0;k<8;k++) {
							//경계 조사
							if(i+drc[k][0]>=0 && i+drc[k][0]<N && j+drc[k][1]>=0 && j+drc[k][1]<N) {
								if(ground[i+drc[k][0]][j+drc[k][1]].equals("W")) {
									count++;
								}
							}
						}
						if(count==0) count=1;
						if(max<count) {
							max=count;
						}
					}
				}
			}//for end
			System.out.println("#"+T+" "+max);
		}//test case end
	}
}