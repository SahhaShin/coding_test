import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			
			//띄어쓰기 없이 괄호들을 받는다.
			char[] blanket = sc.next().toCharArray();
			Stack<Character> stack = new Stack<>();
			String result = "YES";
			
			for(int i=0;i<blanket.length;i++) {
				if(blanket[i]=='(') {
					stack.add(blanket[i]);
				}else {
					if(!stack.isEmpty()) stack.pop();
					else {
						result = "NO";
						break;
					}
				}
			}
			
			if(!stack.isEmpty()) result = "NO";
			
			System.out.println(result);
		}//test case end
	}
}