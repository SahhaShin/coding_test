import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		// 1. test case
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			String result="yes";//최종값을 담을 예정 
			
			char[][] rook = new char[8][8];
			
			//2.data input
			for(int i=0;i<8;i++) {
				rook[i] = sc.next().toCharArray();
			}
			//3. 조건1 - 정확히 8개의 룩이 있어야 한다.
			int count=0;
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
					if(rook[i][j]=='O') {
						count++;
					}
				}
			}
			
			if(count!=8) {
				result="no";
			}
			
			
			//4. 조건2 - 서로 다른 두 룩은 같은 열에 있거나 같은 행에 있으면 안 된다.
			//행조사
			for(int i=0;i<8;i++) {
				count=0; //count변수 재활용 
				for(int j=0;j<8;j++) {
					if(rook[i][j]=='O') {
						count++;
					}
				}
				//한 행에 O가 1개 이상이면 안됨
				if(count>1) {
					result="no";
					break;
				}
			}
			
			//열조사
			for(int i=0;i<8;i++) {
				count=0; //count변수 재활용 
				for(int j=0;j<8;j++) {
					if(rook[j][i]=='O') {
						count++;
					}
				}
				//한 행에 O가 1개 이상이면 안됨
				if(count>1) {
					result="no";
					break;
				}
			}
			
			//5. 결과
			System.out.println("#"+T+" "+result);
			
		}//test case end
	}
}