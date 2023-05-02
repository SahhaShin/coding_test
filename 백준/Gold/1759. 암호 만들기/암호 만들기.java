import java.util.Arrays;
import java.util.Scanner;

public class Main {

	//최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다. 
	static char[] alpha, result;
	static int L,C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();//알파벳 소문자 갯수 4 
		C = sc.nextInt();//암호로 사용했을 법한 문자의 종류 6

		alpha = new char[C];
		result = new char[L];
		for(int i=0;i<C;i++) {
			alpha[i]=sc.next().charAt(0);
		}
		
		//정렬
		Arrays.sort(alpha);
		
		combination(0,0);
		
	}
	
	//조합
	public static void combination(int depth, int c) {
		if(c==L) {
			if(!aeiou(result)) return;
			
			for(int i=0;i<L;i++) {
				System.out.print(result[i]);
			}
			System.out.println();
			return;
		}
		
		if(depth==C) return;
		
		result[c] = alpha[depth];
		combination(depth+1, c+1);
		combination(depth+1, c);	
		
	}
	
	//최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다. 
	public static boolean aeiou(char[] result) {
		char[] aeiou = {'a','e','i','o','u'};

		int x = 0;//모음 갯수
		
		for(int i=0;i<L;i++) {
			for(int j=0;j<5;j++) {
				if(result[i]==aeiou[j]) {
					x++;
					break;
				}
			}
		}
		
		if(L-2<x || x<1)return false;
		else return true;
	}
}