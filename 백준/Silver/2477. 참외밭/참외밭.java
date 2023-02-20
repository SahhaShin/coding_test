import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1. 1m^2에 자라는 참외갯수
		int cham = sc.nextInt();// 7

		// 2. 6개 변의 길이
		// 동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4
		int[] dir_arr = new int[5];//1~4 방향 카운팅 배열
		int[] wich = new int[6];
		int[] size = new int[6];
		for (int i = 0; i < 6; i++) {
			wich[i] = sc.nextInt();
			size[i] = sc.nextInt();
			dir_arr[wich[i]]++;
		}
		
		//System.out.println(Arrays.toString(dir_arr));
		//3. 가로 max , 세로 max 구해라
		// 동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4
		int w_max=0;
		int h_max=0;
		for(int i=0;i<6;i++) {
			if(w_max<size[i] && (wich[i]==1 || wich[i]==2)) {
				w_max=size[i];
			}
			
			if(h_max<size[i] && (wich[i]==3 || wich[i]==4)) {
				h_max=size[i];
			}
		}
		
		//4. 2번 나오는 위치를 구하면 된다.
		//남남 / 북북 -> 작은 사각형의 가로
		//동동 / 서서 -> 작은 사각형의 세로 
		int[] s_sqr=new int[2];
		int idx=0;//s_sqr의 인덱스 
		for(int i=0;i<5;i++) {
			if(dir_arr[i]==2) {
				//2번 나오는 구간 index 을 찾는다. 
				for(int j=0;j<6;j++) {
					//j-1이 0이거나 j+1이 N일 때 끝값도 비교해줘야함 
					if(wich[j]==i && j==0) {
						if(wich[j+1]==wich[5]) {
							s_sqr[idx++]=size[j];//가로 혹은 세로 
							break;
						}
					}
					if(wich[j]==i && j==5) {
						if(wich[j-1]==wich[0]) {
							s_sqr[idx++]=size[j];//가로 혹은 세로 
							break;
						}
					}
					if(wich[j]==i && j-1>=0 && j-1<6 && j+1>=0 && j+1<6) {
						//작은 사각형 높이&가로 정보가 들어올 것 -> 해당 인덱스 사이가 같은가? 33 44...
						if(wich[j-1]==wich[j+1]) {
							s_sqr[idx++]=size[j];//가로 혹은 세로 
							break;
						}
					}
				}
			}
		}//s_sqr end
		
		//5. 사각형 계산 
		int total = (w_max*h_max)-(s_sqr[0]*s_sqr[1]);
		
		System.out.println(total*cham);
		

	}

}
