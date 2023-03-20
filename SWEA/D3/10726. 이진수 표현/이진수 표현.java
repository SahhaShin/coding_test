import java.util.Scanner;

public class Solution {
    //비트 버전
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int t = sc.nextInt();
         
        for(int T=1;T<t+1;T++) {
            int N =sc.nextInt();//마지막 N비트 
            int num = sc.nextInt();//10진수
            
            //비트 1의 자리가 띄워져 있으면 홀수니까 >>를 N번하는 동안 모두 홀수면 ok
            String result="ON";
            for(int i=0;i<N;i++) {
            	if(num%2!=1) {
            		result="OFF";
            		break;
            	}
            	num=num>>1;
            	
            }
             
            System.out.println("#"+T+" "+result);
        }//test case end
    }
}