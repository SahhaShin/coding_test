import java.util.Scanner;
import java.util.Stack;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		
		for(int T=1;T<11;T++) {
			//1. tc 길이
			int len=sc.nextInt();
			
			//2. data input in stack
			char[] str = sc.next().toCharArray();
			int result=1;//1: 유효 / 0: 비유효
			for(int i=0;i<str.length;i++) {
				if(str[i]=='(' || str[i]=='{' || str[i]=='[' || str[i]=='<') {
					stack.push(str[i]);
				}
				else {
					if(str[i]==')') {
						if(stack.pop()!='(') {
							result=0;
							break;
						}
					}
					else if(str[i]=='}') {
						if(stack.pop()!='{') {
							result=0;
							break;
						}
					}
					
					else if(str[i]==']') {
						if(stack.pop()!='[') {
							result=0;
							break;
						}
					}
					else if(str[i]=='>') {
						if(stack.pop()!='<') {
							result=0;
							break;
						}
					}
				}//else end
			}//for end
			System.out.println("#"+T+" "+result);
		}//test case end
	}
}