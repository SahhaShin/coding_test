import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int D,W,K;
	static int[][] origin;
	static int[] A,B;//약품
	static int minDrug=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int T=1;T<=t;T++) {
			D=sc.nextInt();//보호필름두께 
			W=sc.nextInt();//가로크기 
			K=sc.nextInt();//합격기준 
			A=new int[W];
			B=new int[W];
			
			//막 정보 받기 
			origin=new int[D][W];
			for(int i=0;i<D;i++) {
				for(int j=0;j<W;j++) {
					origin[i][j]=sc.nextInt();
				}
			}
			
			//B약품 1처리, A는 기본으로 0처리되서 괜찮음 
			for(int i=0;i<W;i++) {
				B[i]=1;
			}
			
			//연산
			input_drug(0, 0, 1);
			
			//결과 출력
			System.out.println("#"+T+" "+minDrug);
			
			//초기화
			minDrug=Integer.MAX_VALUE;
			
		}//test case end 
	}
	
	/**
	 * 경우의 수는 3가지이다.
	 * 아무것도 처리하지 않음 , 약물 A처리함, 약물 B처리함 
	 * 연속으로 K번 똑같은 약물처리하면 성능검사 통과 (same==K)
	 * =>중복 있는 조합 
	 * 
	 * depth : D 행번호 
	 * count : 약물 몇 번 주입했는지 
	 * same : 같은 약물을 몇 번이나 연속적으로 주입했는지 
	 * */
	
	static public void input_drug(int depth, int count, int same) {
		if(same==K) {
			if(K<=1) same=0; //K가 1보다 작은 경우는 약품을 하나도 주입하지 않아도 된다.
			minDrug=Math.min(minDrug, same);
			return;
		}
		
		if(depth==D) {
			if(test()) {
				minDrug=Math.min(minDrug, count);
			}
			return;
		}
		
		
		
		//아무것도 처리하지 않음 == 0
		input_drug(depth+1,count, 1);
		
		//A처리 == 1
		//약물 주입 
		int[] tempA = origin[depth];
		origin[depth]=A;
		
		//이전과 똑같은 수인지 
		if(depth!=0 && origin[depth-1]==origin[depth]) input_drug(depth+1,count+1, same+1);
		else input_drug(depth+1,count+1, 1);
		
		
		//B처리 == 2
		origin[depth]=B;
		if(depth!=0 && origin[depth-1]==origin[depth]) input_drug(depth+1,count+1, same+1);
		else input_drug(depth+1,count+1, 1);
		
		//원상복구
		origin[depth]=tempA;//tempB를해봤자 tempB에는 A가 들어가있을 것이다.
	}
	
	static public boolean test() {
		for(int i=0;i<W;i++) {
			int same=1;
			boolean flag=false;
			for(int j=0;j<D;j++) {
				if(j!=0 && origin[j-1][i]==origin[j][i]) {
					same++;
					if(same==K) {
						flag=true;
						break;//다음 열 검사 
					}
				}
				else same=1;
			}
			if(flag==false) {
				return false;
			}
		}
		return true;
	}

}