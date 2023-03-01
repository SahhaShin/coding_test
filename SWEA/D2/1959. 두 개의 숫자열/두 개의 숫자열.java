import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. test case
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			//2. 문장 길이 받기
			int t1 = sc.nextInt();
			int t2 = sc.nextInt();
			
			//3. 둘 중 길이가 작은 것이 패턴
			int flen=0;//전체 돌아야할 수 
			int plen=0; //패턴길이 
			if(t1>=t2) {
				//t2가 패턴
				flen=t1-t2+1;
				plen=t2;
			}
			else {
				//t1이 패턴 
				flen=t2-t1+1;
				plen=t1;
			}
			
			//4. 문자들을 받는다. 
			int[] text1 = new int[t1+1];
			int[] text2 = new int[t2+1];
			for(int i=1;i<t1+1;i++) {
				text1[i]=sc.nextInt();
			}
			for(int i=1;i<t2+1;i++) {
				text2[i]=sc.nextInt();
			}
			
			//4. 곱셈이 가장 큰 수 찾기 
			int max=-1;
			if(t1>=t2) {
				max=p_check(text1, text2);
			}
			else{
				max=p_check(text2, text1);
			}
				
			System.out.println("#"+T+" "+max);
		}
	}
	static public int p_check(int[] text, int[] pattern) {
		int op=0;
		int max = -1;
		//연산 후 곱셈값이 가장 큰 수 리턴 
		for(int i=1;i<=text.length-pattern.length+1;i++) {
			for(int j=1;j<pattern.length;j++) {
				int t = text[(i-1)+j];
				int p = pattern[j];
				op+=t*p;	
			}
			if(max<op)max=op;
			op=0;
		}
		return max;
	}

}
