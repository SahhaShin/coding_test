import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//1.test case
		int test = sc.nextInt();
		
		tc:for(int T=1;T<test+1;T++) {
			String result="NO";//결과가 YES / NO를 가져옴 
			
			//2. NXN
			int N=sc.nextInt();
			char[][] omok = new char[N][N];
			
			//3. data input
			for(int i=0;i<N;i++) {
				omok[i]=sc.next().toCharArray();
			}
			
			//4. 연산 
			//o를 발견 -> 우측 row / 아래 col확인 / 아래 대각선 좌 우 확인 
			int[][] drc= {{0,1},{1,0},{1,-1},{1,1}};
			
			//4-1. 오목 NXN 전체 확인 
			start:for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					if(omok[r][c]=='o') {
						//4-2. 4가지 방향 체크 (우측 row / 아래 col확인 / 아래 대각선 좌 우)
						direction:for(int i=0;i<4;i++) {
							int count = 0; //'o' 방향 마다 갯수 책정
							//5개 이상의 오목이 있는가? 
							for(int j=0;j<5;j++) {
								//범위 체크 0 0부터 시작 
								int row=r+(drc[i][0])*j;
								int col=c+(drc[i][1])*j;
								if(row>=0 && row<N && col>=0 && col<N ) {
									if(omok[row][col]=='o') {
										count++;
										if(count==5) {
											result="YES";
											break start;
										}
									}
								}
								else {
									break; //다른 방향 계속 살펴봐 
								}
							}
						}//direction end
					}
				}
			}//start end
			System.out.println("#"+T+" "+result);
			
		}//test case end
	}
}