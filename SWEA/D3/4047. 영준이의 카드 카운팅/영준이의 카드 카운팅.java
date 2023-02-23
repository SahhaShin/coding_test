import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		//1. test case
		int t = sc.nextInt();
		
		for(int T=1;T<t+1;T++) {
			int[] Spa = new int[14];
			int[] Dia = new int[14];
			int[] Hea = new int[14];
			int[] Clo = new int[14];
			
			String str = sc.next();
			int len=str.length();
			//3자리씩 분류
			char pattern='\u0000';
			int num=0;
			for(int i=0;i<len/3;i++) {
				//N번째 카드 요소 3자리 char을 꺼낸다.
				for(int j=0;j<3;j++) {
					//무늬 정보 
					if(j==0) {
						pattern=str.charAt(i*3);
					}
					//숫자 정보
					else {
						int num_1=str.charAt(i*3+j)-'0';//0 1
						num=num*10+num_1;
					}
				}
				if(pattern=='S') {Spa[num]++;}
				else if(pattern=='D') {Dia[num]++;}
				else if(pattern=='H') {Hea[num]++;}
				else if(pattern=='C') {Clo[num]++;}
				num=0;
			}
			//카드 필요 갯수 
			int S_count=0;
			int D_count=0;
			int H_count=0;
			int C_count=0;
			String result=new String();
			for(int i=1;i<14;i++) {
				if(Spa[i]==0)S_count++;
				if(Spa[i]>1) {result="ERROR"; break;}
				if(Dia[i]==0)D_count++;
				if(Dia[i]>1) {result="ERROR"; break;}
				if(Hea[i]==0)H_count++;
				if(Hea[i]>1) {result="ERROR"; break;}
				if(Clo[i]==0)C_count++;
				if(Clo[i]>1) {result="ERROR"; break;}
			}
			
			if(result.equals("ERROR"))System.out.println("#"+T+" "+result);
			else System.out.println("#"+T+" "+S_count+" "+D_count+" "+H_count+" "+C_count);
			
		}//test case end
	}
}