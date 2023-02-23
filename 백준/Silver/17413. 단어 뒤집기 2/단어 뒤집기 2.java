import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] stt = sc.nextLine().split(" ");//statement
		Stack<Character> stack = new Stack<>();
		
		int flag=0;
		
		for(int i=0;i<stt.length;i++) {
			for(int j=0;j<stt[i].length();j++) {
				//<괄호가 나왔다.
				if(stt[i].charAt(j)=='<' || flag==1) {
					//flag=1의 영향으로 > 처리를 안에서 해줘야함 
					if(stt[i].charAt(j)=='>') {
						System.out.print(stt[i].charAt(j));
						flag=0;
						continue;
					}
					
					//이전 stack 내용 꺼내고 < 처리
					while(!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
					
					//<처리 
					System.out.print(stt[i].charAt(j));
					flag=1;
				}
				//괄호 이외 처리 
				else {
					stack.push(stt[i].charAt(j));
				}
			}
			
			//다른 단어로 바뀌기 전에 pop
			while(!stack.isEmpty()) {
				System.out.print(stack.pop());
			}
			System.out.print(" ");//스페이스 기준으로 split해서 단어마다 하나씩 해줘야함 
			
		}//for end

	}

}
