import java.util.LinkedList;
import java.util.Scanner;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		//testcase 10
		for(int T=1;T<11;T++) {
			//1. 암호문의 길이
			int len = sc.nextInt();
			
			//2. 원본 암호문 - 링크드리스트
			LinkedList<Integer> origin = new LinkedList<>();

			for(int i=0;i<len;i++) {
				origin.add(sc.nextInt());
			}
			
			//3. 명령어 갯수
			int order_len = sc.nextInt();
			
			//I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.
			//D(삭제) x, y : 앞에서부터 x의 위치 바로 다음부터 y개의 숫자를 삭제한다.
			//A(추가) y, s : 암호문의 맨 뒤에 y개의 숫자를 덧붙인다. s는 덧붙일 숫자들이다.
			
			//4. 명령어 입력 
			for(int i=0;i<order_len;i++) {
				String order=sc.next();//I
				switch(order) {
				case "I":
					int x_i=sc.nextInt();//3
					int y_i=sc.nextInt();//2
					for(int I=0;I<y_i;I++) {
						origin.add(x_i+I, sc.nextInt()); //123152 487651
					}
					
					//System.out.print("\nI "+ origin);
					break;
					
				case "D":
					int x_d=sc.nextInt();//4
					int y_d=sc.nextInt();//4
					for(int D=0;D<y_d;D++) {
						origin.remove(x_d);
					}
					
					
					//System.out.print("\nD "+ origin);
					
					break;
					
				case "A":
					int x_a=sc.nextInt();//2
					for(int A=0;A<x_a;A++) {
						origin.addLast(sc.nextInt()); //421257 796813
					}
					
					//System.out.print("\nA "+ origin);
					break;
				}
			}//명령어 입력 끝 / 명령어 처리 끝
			System.out.print("#"+T+" ");
			for(int i=0;i<10;i++) {
				System.out.print(origin.pop()+" ");
			}
			System.out.println();
		}//TEST CASE END
	}
}