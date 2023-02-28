import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. 색종이 수 
		int count=sc.nextInt();
		int[][] paper = new int[101][101];
		int result=0;
		for(int T=1;T<=count;T++) {
			//2. 색종이 시작 위치 받기 (좌하)
			int x= sc.nextInt(); //3 col
			int y=sc.nextInt(); //7 row
			
			//3. 색종이 영역 색칠 
			for(int r=y;r<y+10;r++) {
				for(int c=x;c<x+10;c++) {
					//경계 설정 
					if(r>=0 && r<=100 && c>=0 && c<=100) {
						if(paper[r][c]==0) {
							paper[r][c]=1;
							result++;
						}
					}
				}
			}
		}
		
		//4. 결과 출력
		System.out.println(result);
		
	

	}

}
