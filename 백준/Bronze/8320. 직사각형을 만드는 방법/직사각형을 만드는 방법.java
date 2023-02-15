

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. 정사각형 갯수
		int square = sc.nextInt(); //6
		int result=0;
		int[] index=new int[10001];
		//1개로만들때 2개로 만들때 ... 6개로 만들 때 
		//4
		for(int i=1;i<square+1;i++) {	
			if(i==1) {
				result++;
				continue;
			}
			for(int j=1;j<i+1;j++) {
				if(i%j==0) {
					if(index[j]==0 && index[i/j]==0) {
						//System.out.println(i+" "+j);
						index[j]++;
						index[i/j]++; 
						result++;
					}
					else {
						break;
					}
				}
				
			}//for end
			index=new int[10001]; //index 초기
	
		}// 1 for end
		System.out.println(result);

	}//main end

}
