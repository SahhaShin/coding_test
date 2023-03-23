import java.util.Scanner;

public class Solution {
	
	static int[] row;//인덱스 번호는 row 번호, 값은 퀸이 있는 col 번호
	static int n; //체크 판의 크기 nxn
	static int result=0; //경우의 수 갯수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int T=1;T<=t;T++) {
			n = sc.nextInt(); //하나의 자연수
			row=new int[n];
			chess(0);
			System.out.println("#"+T+" "+result);
			result=0; //초기화
		}//test case end

	}
	
	/**
	 * 한 행에는 하나의 퀸이 들어갈 수 있다고 가정한다.
	 * 한 행은 depth로 표기한다.
	 * 한 행의 하나의 퀸이 정해지면 다음 depth로 이동한다.
	 * 한 행마다 어떤 열에 들어가면 좋을지 for문을 돌려 재귀를 한다.
	 * 만약 depth로 들어가다가 만족하지 않으면 돌아 나와 다른 가능성을 체킹한다 = 백트래킹
	 */
	static public void chess(int depth) {
		//기저 조건, 종료조건
		
		//퀸 n개 설치를 완료했다. -> result+1 -> 종료
		if(depth==n) {
			result++;
			return;
		}
		
		//모든 열을 돌며 퀸을 놓을 수 있는 자리가 있으면 재귀
		//없으면 백트래킹으로 다른 가능성 찾기
		for(int i=0;i<n;i++) {
			row[depth]=i;//depth행, i열에 퀸을 배치한다.
			if(possible(depth)) {//그렇게 배치해도 되니?
				//배치가능하면 다음 열의 퀸을 배치할 곳을 물색하러 감
				chess(depth+1);
			}
			
			//배치가 불가능하면 다른 열 위치를 찾음
			
		}
	}
	
	/** 퀸은 8방을 자유롭게 돌아다닐 수 있다.
	 * 행 체크 : chess 함수에서 행을 depth로 보고 1개가 정해지면 다음 depth로 넘어가기 때문에 체크 안해줘도 된다.
	 * 열 체크 : row 배열은 depth(행)별 퀸이 있는 자리를 나타내므로 값이 정해진 depth까지 배열을 탐색했을 때 같은 값이 있으면 false
	 * 대각선 체크 : depth(행)별 퀸의 위치를 (r1,c1) 내가 현재 퀸을 넣으려고 하는 위치를 (r2,c2)로 본다.
	 * 대각선 체크 : r1-r2의 절대값과 c1-c2의 절대값이 같으면 같은 대각선에 있는 것으로 본다. 
	 * */
	static public boolean possible(int depth) {
		
		for(int i=0;i<depth;i++) {
			//열체크
			if(row[i]==row[depth]) {
				return false;
			}
			
			//대각선 체크 (i, depth는 행번호)
			if(Math.abs(i-depth)==Math.abs(row[i]-row[depth])) {
				return false;
			}
		}
		
		//위 조건을 모두 만족하면 true
		return true;
	}

}