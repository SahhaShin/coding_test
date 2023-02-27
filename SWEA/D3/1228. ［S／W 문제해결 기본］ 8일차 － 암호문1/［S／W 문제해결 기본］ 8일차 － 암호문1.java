import java.util.LinkedList;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for(int T=1;T<11;T++) {
			//1. 원본 암호문의 길이
			int N=sc.nextInt();
			
			LinkedList<Integer> ll = new LinkedList<>();//원본 암호문
			
			//2. 원본 암호문
			for(int i=0;i<N;i++) {
				ll.offer(sc.nextInt());
			}
			
			//3. 명령어 갯수
			int order_count = sc.nextInt();
			
			//4. 삽입 명령어 받기
			// I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다.
			// s는 덧붙일 숫자들이다.[ ex) I 3 2 123152 487651 ]
			for(int i=0;i<order_count;i++) {
				String insert=sc.next();
				if(insert.equals("I")) {
					int wich = sc.nextInt();
					int count=sc.nextInt();
					
					for(int j=0;j<count;j++) {
						ll.add(wich+j, sc.nextInt());
					}
					
				}
			}
			
			System.out.print("#"+T+" ");
			
			//5. 10개 아이템 출력
			for(int i=0;i<10;i++) {
				System.out.print(ll.pop()+" ");
			}
			System.out.println();
		}//test case end
	}
}