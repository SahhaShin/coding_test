import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//4가지 테스트 케이스 
		for(int T=1;T<5;T++) {
			//색종이 1, 1번 3번 지점 받기
			int s1_x1 =sc.nextInt();
			int s1_y1 =sc.nextInt();
			int s1_x3 =sc.nextInt();
			int s1_y3 =sc.nextInt();
			
			int s2_x1 =sc.nextInt();
			int s2_y1 =sc.nextInt();
			int s2_x3 =sc.nextInt();
			int s2_y3 =sc.nextInt();
			
			//1. 4개의 점 저장 
			square s1 = new square(s1_x1,s1_y1,s1_x3,s1_y1,s1_x3,s1_y3,s1_x1,s1_y3);
			square s2 = new square(s2_x1,s2_y1,s2_x3,s2_y1,s2_x3,s2_y3,s2_x1,s2_y3);
			
			//2. 구현
			char result='a';//기본 직사각형이 겹친다.
			
			//2-1. code d 구현
			//s1의 1번 지점보다 s2의 2번 지점이 왼쪽에 있다.
			if(s1.x1>s2.x2) {
				result='d';
				
			}
			
			//s1의 2번 지점보다 s2의 1번 지점이 오른쪽에 있다.
			else if(s1.x2<s2.x1) {
				result='d';
			}
			
			//s1의 3번 지점보다 s2의 1번 지점이 위쪽에 있다.
			else if(s1.y3<s2.y1) {
				result='d';
			}
			
			//s1의 1번 지점보다 s2의 4번 지점이 아래쪽에 있다.
			else if(s1.y1>s2.y4) {
				result='d';
			}
			
			
			//x는 다른데 y가 다르거
			
			//2-2. code c 구현
			//오로지 한 점만 같아야 한다. (4가지 케이스)
			//s1 1번 점 == s2 3번 점 
			else if(s1.x1==s2.x3 && s1.y1==s2.y3) {
				result='c';
			}
			
			//s1 2번 점 == s2 4번 점 
			else if(s1.x2==s2.x4 && s1.y2==s2.y4) {
				result='c';
			}
			
			//s1 3번 점 == s2 1번 점 
			else if(s1.x3==s2.x1 && s1.y3==s2.y1) {
				result='c';
			}
			
			//s4 4번 점 == s2 2번 점 
			else if(s1.x4==s2.x2 && s1.y4==s2.y2) {
				result='c';
			}
			
			//2-3. code b 구현
			//x좌표 혹은 y좌표가 같아야 한다. (4가지 케이스)
			//s1 1,2 == s2 3 4 x가 같다. -> 이들은 평행이기 때문에 1 4의 x가 같다고 해주면 된다.
			else if(s1.y1==s2.y4) {
				result='b';
			}
			
			//s1 3,4 == s2 1 2 x가 같다. -> 이들은 평행이기 때문에 4 1의 x가 같다고 해주면 된다.
			else if(s1.y4==s2.y1) {
				result='b';
			}
			
			//s1 2,3 == s2 1 4 y가 같다. -> 이들은 평행이기 때문에 2 4의 y가 같다고 해주면 된다.
			else if(s1.x2==s2.x4) {
				result='b';
			}
			
			//s1 1,4 == s2 2 3 y가 같다. -> 이들은 평행이기 때문에 1 2의 y가 같다고 해주면 된다.
			else if(s1.x1==s2.x2) {
				result='b';
			}
			
			//만약 모든 케이스도 닿지 않는다면 a케이스
			System.out.println(result);
		}

	}
	static public class square {
		//직사각형의 4개점들 
		int x1;
		int y1;
		
		int x2;
		int y2;
		
		int x3;
		int y3;
		
		int x4;
		int y4;
		
		public square(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
			this.x1=x1;
			this.y1=y1;
			
			this.x2=x2;
			this.y2=y2;
			
			this.x3=x3;
			this.y3=y3;
			
			this.x4=x4;
			this.y4=y4;
		}
		
	}
	
	
}