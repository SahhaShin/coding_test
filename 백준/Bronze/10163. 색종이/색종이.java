import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. 색종이 장수
		int count=sc.nextInt();
		int[][] paper = new int[1002][1002]; //최대 1001칸 
		int[] result=new int[101];//최대 색종이 100장 
		int idx=1;//1부터 인덱스 쓸것임 
		
		for(int i=0;i<count;i++) {
			//2. 가장 왼쪽 아래칸 좌표
			int x= sc.nextInt(); //1
			int y=sc.nextInt(); //4
			
			int w = sc.nextInt();//가로 3
			int h = sc.nextInt();//세로 2
			
			//3. 해당 위치 넓이, 높이만큼 색칠 
			//가로는 h만큼 2
			//세로는 w만큼 3
			for(int r=y;r<y+h;r++) {
				for(int c=x;c<x+w;c++) {
					//4. 각 색종이 색칠된 부분 세기 
					//칠해져있지 않은 공간 +1
					if(paper[r][c]==0) {
						paper[r][c]=idx;//자신의 색종이 idx를 가지고 영역 소개 
						result[idx]++;
					}
					else if(idx!=0 && paper[r][c]>0) {
						//다음 색종이가 칠해져있는 공간을 침범한다면 이전 색종이 넓이 삭제 & 내 넓이로 만들기 즉 공간 뺏어오기 
						result[paper[r][c]]--; //원래 색종이 범위 지우고, 
						paper[r][c]=idx;//현재 내 색종이 idx로 영역 바꾸기 
						result[idx]++; //내영역으로 계산 
					}
					
				}
			}
			idx+=1;
		}
		
		//5. 결과출력
		for(int i=1;i<count+1;i++) {
			System.out.println(result[i]);
		}
		

	}

}
